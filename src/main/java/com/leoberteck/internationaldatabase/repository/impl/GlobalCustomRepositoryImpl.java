package com.leoberteck.internationaldatabase.repository.impl;

import com.leoberteck.internationaldatabase.repository.interfaces.GlobalCustomRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class GlobalCustomRepositoryImpl<T, ID, REP extends JpaRepository<T, ID>>
        implements GlobalCustomRepository<T, ID> {

    private final REP repository;
    private final EntityManagerFactory entityManagerFactory;

    public GlobalCustomRepositoryImpl(EntityManagerFactory entityManagerFactory, REP repository) {
        this.entityManagerFactory = entityManagerFactory;
        this.repository = repository;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {
        repository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends T> S save(S s) {
        return repository.save(s);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        return repository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {
        repository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    public T getOne(ID id) {
        return repository.getOne(id);
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<T> findAllById(Iterable<ID> iterable) {
        return repository.findAllById(iterable);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Transactional
    @Override
    public List<T> findAll(Long locale) {
        return executeWithFilter(locale, repository::findAll);
    }

    @Transactional
    @Override
    public List<T> findAll(Long locale, Sort sort) {
        return executeWithFilter(locale, () -> repository.findAll(sort));
    }

    @Transactional
    @Override
    public Page<T> findAll(Long locale, Pageable pageable) {
        return executeWithFilter(locale, () -> repository.findAll(pageable));
    }

    @Transactional
    @Override
    public List<T> findAllById(Long locale, Iterable<ID> iterable) {
        return executeWithFilter(locale, () -> repository.findAllById(iterable));
    }

    @Transactional
    @Override
    public Optional<T> findById(Long locale, ID id) {
        return executeWithFilter(locale, () -> repository.findById(id));
    }

    @Transactional
    @Override
    public T getOne(Long locale, ID id) {
        return executeWithFilter(locale, () -> repository.getOne(id));
    }

    @Transactional
    @Override
    public <S extends T> List<S> findAll(Long locale, Example<S> example, Sort sort) {
        return executeWithFilter(locale, () -> repository.findAll(example, sort));
    }

    @Transactional
    @Override
    public <S extends T> List<S> findAll(Long locale, Example<S> example) {
        return executeWithFilter(locale, () -> repository.findAll(example));
    }

    @Transactional
    @Override
    public <S extends T> Optional<S> findOne(Long locale, Example<S> example) {
        return executeWithFilter(locale, () -> repository.findOne(example));
    }

    @Transactional
    @Override
    public <S extends T> Page<S> findAll(Long locale, Example<S> example, Pageable pageable) {
        return executeWithFilter(locale, () -> repository.findAll(example, pageable));
    }

    /**
     * Ativa o filtro de locale na sessao do hibernate e
     * executa uma funçao do JPA.
     * @param locale O LCID da localidade do request
     * @param statement A funçao JPA a ser executada
     * @param <A> O tipo do retorno da funçao
     * @return O retorno da funcao JPA executa com filtro de localidade
     */
    private <A> A executeWithFilter(Long locale, Statement<A> statement){
        //Obtain the entity manager for the current transaction
        EntityManagerHolder holder = (EntityManagerHolder) TransactionSynchronizationManager.getResource(entityManagerFactory);
        EntityManager entityManager = holder.getEntityManager();

        //Unwrap to get the underlying hibernate session
        Session hibernateSession = entityManager.unwrap(Session.class);

        //Configure your filters
        Filter localeFilter = hibernateSession.enableFilter("localeFilter");
        localeFilter.setParameter("locale", locale);
        localeFilter.validate();

        return statement.execute();
    }

    private interface Statement<A> {
        A execute();
    }
}
