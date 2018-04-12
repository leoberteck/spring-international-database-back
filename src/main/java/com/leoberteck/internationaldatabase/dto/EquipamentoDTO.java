package com.leoberteck.internationaldatabase.dto;

import java.time.ZonedDateTime;

public class EquipamentoDTO {
    private Long cdEquipamento;
    private String cdSerie;
    private String cdTurma;
    private Integer cdHrPontoElet;
    private Integer cdRelogio;
    private Integer fgImplementoFixo;
    private ZonedDateTime dtUtlAlteracao;
    private Long cdModeloEquipamento;
    private String modeloEquipamento;
    private Long cdTipoEquipamento;
    private String tipoEquipamento;
    private Long cdGrupoEquipamento;
    private String grupoEquipamento;
    private Long cdDescEquipamento;
    private String descEquipamento;

    public EquipamentoDTO() { }

    public EquipamentoDTO(Long cdEquipamento, String cdSerie, String cdTurma, Integer cdHrPontoElet, Integer cdRelogio, Integer fgImplementoFixo, ZonedDateTime dtUtlAlteracao, Long cdModeloEquipamento, String modeloEquipamento, Long cdTipoEquipamento, String tipoEquipamento, Long cdGrupoEquipamento, String grupoEquipamento, Long cdDescEquipamento, String descEquipamento) {
        this.cdEquipamento = cdEquipamento;
        this.cdSerie = cdSerie;
        this.cdTurma = cdTurma;
        this.cdHrPontoElet = cdHrPontoElet;
        this.cdRelogio = cdRelogio;
        this.fgImplementoFixo = fgImplementoFixo;
        this.dtUtlAlteracao = dtUtlAlteracao;
        this.cdModeloEquipamento = cdModeloEquipamento;
        this.modeloEquipamento = modeloEquipamento;
        this.cdTipoEquipamento = cdTipoEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.cdGrupoEquipamento = cdGrupoEquipamento;
        this.grupoEquipamento = grupoEquipamento;
        this.cdDescEquipamento = cdDescEquipamento;
        this.descEquipamento = descEquipamento;
    }

    public Long getCdEquipamento() {
        return cdEquipamento;
    }

    public void setCdEquipamento(Long cdEquipamento) {
        this.cdEquipamento = cdEquipamento;
    }

    public String getCdSerie() {
        return cdSerie;
    }

    public void setCdSerie(String cdSerie) {
        this.cdSerie = cdSerie;
    }

    public String getCdTurma() {
        return cdTurma;
    }

    public void setCdTurma(String cdTurma) {
        this.cdTurma = cdTurma;
    }

    public Integer getCdHrPontoElet() {
        return cdHrPontoElet;
    }

    public void setCdHrPontoElet(Integer cdHrPontoElet) {
        this.cdHrPontoElet = cdHrPontoElet;
    }

    public Integer getCdRelogio() {
        return cdRelogio;
    }

    public void setCdRelogio(Integer cdRelogio) {
        this.cdRelogio = cdRelogio;
    }

    public Integer getFgImplementoFixo() {
        return fgImplementoFixo;
    }

    public void setFgImplementoFixo(Integer fgImplementoFixo) {
        this.fgImplementoFixo = fgImplementoFixo;
    }

    public ZonedDateTime getDtUtlAlteracao() {
        return dtUtlAlteracao;
    }

    public void setDtUtlAlteracao(ZonedDateTime dtUtlAlteracao) {
        this.dtUtlAlteracao = dtUtlAlteracao;
    }

    public Long getCdModeloEquipamento() {
        return cdModeloEquipamento;
    }

    public void setCdModeloEquipamento(Long cdModeloEquipamento) {
        this.cdModeloEquipamento = cdModeloEquipamento;
    }

    public String getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(String modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public Long getCdTipoEquipamento() {
        return cdTipoEquipamento;
    }

    public void setCdTipoEquipamento(Long cdTipoEquipamento) {
        this.cdTipoEquipamento = cdTipoEquipamento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Long getCdGrupoEquipamento() {
        return cdGrupoEquipamento;
    }

    public void setCdGrupoEquipamento(Long cdGrupoEquipamento) {
        this.cdGrupoEquipamento = cdGrupoEquipamento;
    }

    public String getGrupoEquipamento() {
        return grupoEquipamento;
    }

    public void setGrupoEquipamento(String grupoEquipamento) {
        this.grupoEquipamento = grupoEquipamento;
    }

    public Long getCdDescEquipamento() {
        return cdDescEquipamento;
    }

    public void setCdDescEquipamento(Long cdDescEquipamento) {
        this.cdDescEquipamento = cdDescEquipamento;
    }

    public String getDescEquipamento() {
        return descEquipamento;
    }

    public void setDescEquipamento(String descEquipamento) {
        this.descEquipamento = descEquipamento;
    }
}