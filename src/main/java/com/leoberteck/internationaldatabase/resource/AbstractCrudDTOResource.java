package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Nonnull;
import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;
import java.util.List;

public abstract class AbstractCrudDTOResource<DTO, ETY, ID> extends AbstractReadOnlyResource<DTO, ETY, ID> {


    public AbstractCrudDTOResource(
            @Nonnull EntityManagerFactory entityManagerFactory
            , @Nonnull JpaRepository<ETY, ID> repository
            , @Nonnull BaseMapper<ETY, DTO> mapper) {
        super(entityManagerFactory, repository, mapper);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DTO> create(@RequestBody @Valid DTO dto) {
        return ResponseEntity.ok(
            mapper.convertBack(
                repository.save(
                    mapper.convert(dto)
                )
            )
        );
    }

    @RequestMapping(path = "/lista", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List<DTO>> createList(@RequestBody @Valid List<DTO> listDTO) {
        return ResponseEntity.ok(
            mapper.convertBack(
                repository.saveAll(
                    mapper.convert(listDTO)
                )
            )
        );
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<DTO> update(@RequestBody @Valid DTO dto) {
        return ResponseEntity.ok(
            mapper.convertBack(
                repository.save(
                    mapper.convert(dto)
                )
            )
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id:.+}")
    public ResponseEntity delete(@PathVariable ID id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
