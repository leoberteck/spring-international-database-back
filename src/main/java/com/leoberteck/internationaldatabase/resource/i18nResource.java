package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.entity.I18N;
import com.leoberteck.internationaldatabase.mapper.impl.EchoMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.I18nRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping("/i18n")
public class i18nResource extends AbstractCrudDTOResource<I18N, I18N, Long> {

    public i18nResource(@Nonnull EntityManagerFactory entityManagerFactory, @Nonnull I18nRepository repository, @Nonnull EchoMapper<I18N> mapper) {
        super(entityManagerFactory, repository, mapper);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id:.+}")
    public ResponseEntity findById(@RequestHeader Long locale, @PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
