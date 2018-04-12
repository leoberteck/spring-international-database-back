package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import com.leoberteck.internationaldatabase.repository.impl.GlobalCustomRepositoryImpl;
import com.leoberteck.internationaldatabase.repository.interfaces.GlobalCustomRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Nonnull;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public abstract class AbstractReadOnlyResource<DTO, ETY, ID> {

    private static final ExampleMatcher defaultMatcher =
        ExampleMatcher.matching()
        .withIgnoreCase()
        .withIgnoreNullValues()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    @Nonnull
    protected final GlobalCustomRepository<ETY, ID> repository;
    @Nonnull
    protected final BaseMapper<ETY, DTO> mapper;


    public AbstractReadOnlyResource(
            @Nonnull EntityManagerFactory entityManagerFactory
            , @Nonnull JpaRepository<ETY, ID> repository
            , @Nonnull BaseMapper<ETY, DTO> mapper) {
        this.repository = new GlobalCustomRepositoryImpl<>(entityManagerFactory, repository);
        this.mapper = mapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> findAll(@RequestHeader Long locale) {
        return ResponseEntity.ok(mapper.convertBack(repository.findAll(locale)));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/paginado")
    public ResponseEntity<Page> findAllPaginated(@RequestHeader Long locale, DTO dto, Pageable page) {
        Page<ETY> result;
        try {
            ETY ety = mapper.convert(dto);
            Example<ETY> example = Example.of(ety, defaultMatcher);
            result = repository.findAll(locale, example, page);
        } catch (Exception e){
            result = repository.findAll(locale, page);
        }
        return ResponseEntity.ok(mapper.convertPage(result, page));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id:.+}")
    public ResponseEntity findById(@RequestHeader Long locale, @PathVariable ID id) {
        Optional<ETY> result = repository.findById(locale, id);
        return result.<ResponseEntity>map(
                ety -> ResponseEntity.ok(mapper.convertBack(ety)))
            .orElseGet(
                () -> ResponseEntity.notFound().build());
    }

}