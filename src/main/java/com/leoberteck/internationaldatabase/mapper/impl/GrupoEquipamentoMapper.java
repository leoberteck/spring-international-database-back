package com.leoberteck.internationaldatabase.mapper.impl;

import com.leoberteck.internationaldatabase.dto.GrupoEquipamentoDTO;
import com.leoberteck.internationaldatabase.entity.GrupoEquipamento;
import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.I18nRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoEquipamentoMapper implements BaseMapper<GrupoEquipamento, GrupoEquipamentoDTO> {

    private I18nRepository i18nRepository;

    @Autowired
    public GrupoEquipamentoMapper(I18nRepository i18nRepository) {
        this.i18nRepository = i18nRepository;
    }

    @Override
    public GrupoEquipamentoDTO convertBack(GrupoEquipamento grupoEquipamento) {
        return new GrupoEquipamentoDTO(
            grupoEquipamento.getCdGrupoEquipamento()
            , grupoEquipamento.getFgFrenteTrabalho()
            , grupoEquipamento.getVlCorGrafico()
            , grupoEquipamento.getCdUnidade()
            , grupoEquipamento.getCdDescGrupoEquipamento().getI18N()
            , grupoEquipamento.getDescGrupoEquipamentoI18N()
        );
    }

    @Override
    public GrupoEquipamento convert(GrupoEquipamentoDTO grupoEquipamentoDTO) {
        return new GrupoEquipamento(
            grupoEquipamentoDTO.getCdGrupoEquipamento()
            , grupoEquipamentoDTO.getFgFrenteTrabalho()
            , grupoEquipamentoDTO.getVlCorGrafico()
            , grupoEquipamentoDTO.getCdUnidade()
            , i18nRepository.getOne(grupoEquipamentoDTO.getCdDescGrupoEquipamento())
            , grupoEquipamentoDTO.getDescGrupoEquipamento()
        );
    }
}
