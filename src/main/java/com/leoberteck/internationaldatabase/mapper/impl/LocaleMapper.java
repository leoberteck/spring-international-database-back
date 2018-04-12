package com.leoberteck.internationaldatabase.mapper.impl;

import com.leoberteck.internationaldatabase.dto.LocaleDTO;
import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import com.leoberteck.internationaldatabase.entity.Locale;
import com.leoberteck.internationaldatabase.repository.interfaces.I18nRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocaleMapper implements BaseMapper<Locale,LocaleDTO> {

    private I18nRepository i18nRepository;

    @Autowired
    public LocaleMapper(I18nRepository i18nRepository) {
        this.i18nRepository = i18nRepository;
    }

    @Override
    public LocaleDTO convertBack(Locale locale) {
        return new LocaleDTO(
            locale.getLcid()
            , locale.getCode()
            , locale.getCharset()
            , locale.getCdDescricao().getI18N()
            , locale.getDescricaoI18N()
        );
    }

    @Override
    public Locale convert(LocaleDTO localeDTO) {
        return new Locale(
            localeDTO.getLcid()
            , localeDTO.getCode()
            , localeDTO.getCharset()
            , i18nRepository.getOne(localeDTO.getCdDescricao())
            , localeDTO.getDescricao()
        );
    }
}