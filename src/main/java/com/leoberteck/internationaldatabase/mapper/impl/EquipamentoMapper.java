package com.leoberteck.internationaldatabase.mapper.impl;

import com.leoberteck.internationaldatabase.dto.EquipamentoDTO;
import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import com.leoberteck.internationaldatabase.entity.Equipamento;
import com.leoberteck.internationaldatabase.repository.interfaces.GrupoEquipamentoRepository;
import com.leoberteck.internationaldatabase.repository.interfaces.I18nRepository;
import com.leoberteck.internationaldatabase.repository.interfaces.ModeloEquipamentoRepository;
import com.leoberteck.internationaldatabase.repository.interfaces.TipoEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper implements BaseMapper<Equipamento, EquipamentoDTO> {

    private ModeloEquipamentoRepository modeloEquipamentoRepository;
    private GrupoEquipamentoRepository grupoEquipamentoRepository;
    private TipoEquipamentoRepository tipoEquipamentoRepository;
    private I18nRepository i18nRepository;

    @Autowired
    public EquipamentoMapper(ModeloEquipamentoRepository modeloEquipamentoRepository, GrupoEquipamentoRepository grupoEquipamentoRepository, TipoEquipamentoRepository tipoEquipamentoRepository, I18nRepository i18nRepository) {
        this.modeloEquipamentoRepository = modeloEquipamentoRepository;
        this.grupoEquipamentoRepository = grupoEquipamentoRepository;
        this.tipoEquipamentoRepository = tipoEquipamentoRepository;
        this.i18nRepository = i18nRepository;
    }

    @Override
    public EquipamentoDTO convertBack(Equipamento equipamento) {
        return new EquipamentoDTO(
            equipamento.getCdEquipamento()
            , equipamento.getCdSerie()
            , equipamento.getCdTurma()
            , equipamento.getCdHrPontoElet()
            , equipamento.getCdRelogio()
            , equipamento.getFgImplementoFixo()
            , equipamento.getDtUltAlteracao()
            , equipamento.getCdModeloEquipamento() != null ? equipamento.getCdModeloEquipamento().getCdModeloEquipamento() : 0
            , equipamento.getCdModeloEquipamento() != null ? equipamento.getCdModeloEquipamento().getDescModeloEquipamentoI18N() : null
            , equipamento.getCdTipoEquipamento() != null ? equipamento.getCdTipoEquipamento().getCdTpEquipamento() : 0
            , equipamento.getCdTipoEquipamento() != null ? equipamento.getCdTipoEquipamento().getDescTpEquipamentoI18N() : null
            , equipamento.getCdGrupoEquipamento() != null ? equipamento.getCdGrupoEquipamento().getCdGrupoEquipamento() : 0
            , equipamento.getCdGrupoEquipamento() != null ? equipamento.getCdGrupoEquipamento().getDescGrupoEquipamentoI18N() : null
            , equipamento.getCdDescEquipamento() != null ? equipamento.getCdDescEquipamento().getI18N() : null
            , equipamento.getDescEquipamentoI18N()
        );
    }

    @Override
    public Equipamento convert(EquipamentoDTO equipamentoDTO) {
        return new Equipamento(
            equipamentoDTO.getCdEquipamento()
            , equipamentoDTO.getCdSerie()
            , equipamentoDTO.getCdTurma()
            , equipamentoDTO.getCdHrPontoElet()
            , equipamentoDTO.getCdRelogio()
            , equipamentoDTO.getFgImplementoFixo()
            , equipamentoDTO.getDtUtlAlteracao()
            , modeloEquipamentoRepository.getOne(equipamentoDTO.getCdModeloEquipamento())
            , tipoEquipamentoRepository.getOne(equipamentoDTO.getCdTipoEquipamento())
            , grupoEquipamentoRepository.getOne(equipamentoDTO.getCdGrupoEquipamento())
            , equipamentoDTO.getCdDescEquipamento() != null
                && equipamentoDTO.getCdDescEquipamento() != null
                    ? i18nRepository.getOne(equipamentoDTO.getCdDescEquipamento())
                    : null
            , equipamentoDTO.getDescEquipamento()
        );
    }
}