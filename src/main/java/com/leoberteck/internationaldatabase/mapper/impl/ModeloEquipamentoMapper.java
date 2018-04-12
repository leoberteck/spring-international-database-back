package com.leoberteck.internationaldatabase.mapper.impl;

import com.leoberteck.internationaldatabase.dto.ModeloEquipamentoDTO;
import com.leoberteck.internationaldatabase.entity.ModeloEquipamento;
import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.I18nRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModeloEquipamentoMapper implements BaseMapper<ModeloEquipamento, ModeloEquipamentoDTO> {

    private I18nRepository i18nRepository;

    @Autowired
    public ModeloEquipamentoMapper(I18nRepository i18nRepository) {
        this.i18nRepository = i18nRepository;
    }

    @Override
    public ModeloEquipamentoDTO convertBack(ModeloEquipamento modeloEquipamento) {
        return new ModeloEquipamentoDTO(
            modeloEquipamento.getCdModeloEquipamento()
            , modeloEquipamento.getVlEspacamento()
            , modeloEquipamento.getCdIcone()
            , modeloEquipamento.getVlLargura()
            , modeloEquipamento.getVlComprimento()
            , modeloEquipamento.getVlCapacidade()
            , modeloEquipamento.getCdDescModeloEquipamento().getI18N()
            , modeloEquipamento.getDescModeloEquipamentoI18N()
        );
    }

    @Override
    public ModeloEquipamento convert(ModeloEquipamentoDTO modeloEquipamentoDTO) {
        return new ModeloEquipamento(
            modeloEquipamentoDTO.getCdModeloEquipamento()
            , modeloEquipamentoDTO.getVlEspacamento()
            , modeloEquipamentoDTO.getCdIcone()
            , modeloEquipamentoDTO.getVlLargura()
            , modeloEquipamentoDTO.getVlComprimento()
            , modeloEquipamentoDTO.getVlCapacidade()
            , i18nRepository.getOne(modeloEquipamentoDTO.getCdDescModeloEquipamento())
            , modeloEquipamentoDTO.getDescModeloEquipamento()
        );
    }
}
