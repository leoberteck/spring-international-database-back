package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.dto.LocaleDTO;
import com.leoberteck.internationaldatabase.entity.Locale;
import com.leoberteck.internationaldatabase.mapper.impl.LocaleMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping("/locales")
public class LocaleResource extends AbstractReadOnlyResource<LocaleDTO, Locale, Long> {

    @Autowired
    public LocaleResource(@Nonnull EntityManagerFactory entityManagerFactory, @Nonnull LocaleRepository repository, @Nonnull LocaleMapper mapper) {
        super(entityManagerFactory, repository, mapper);
    }
}
