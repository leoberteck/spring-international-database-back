package com.leoberteck.internationaldatabase.repository.interfaces;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GlobalCustomRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findAll(Long locale);
    List<T> findAll(Long locale, Sort sort);
    Page<T> findAll(Long locale, Pageable pageable);
    List<T> findAllById(Long locale, Iterable<ID> iterable);
    Optional<T> findById(Long locale, ID id);
    T getOne(Long locale, ID id);
    <S extends T> List<S> findAll(Long locale, Example<S> example, Sort sort);
    <S extends T> List<S> findAll(Long locale, Example<S> example);
    <S extends T> Optional<S> findOne(Long locale, Example<S> example);
    <S extends T> Page<S> findAll(Long locale, Example<S> example, Pageable pageable);
}
