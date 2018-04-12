package com.leoberteck.internationaldatabase.dto;

public class GrupoEquipamentoDTO {
    private Long cdGrupoEquipamento;
    private Integer fgFrenteTrabalho;
    private String vlCorGrafico;
    private Integer cdUnidade;
    private Long cdDescGrupoEquipamento;
    private String descGrupoEquipamento;

    public GrupoEquipamentoDTO(Long cdGrupoEquipamento, Integer fgFrenteTrabalho, String vlCorGrafico, Integer cdUnidade, Long cdDescGrupoEquipamento, String descGrupoEquipamento) {
        this.cdGrupoEquipamento = cdGrupoEquipamento;
        this.fgFrenteTrabalho = fgFrenteTrabalho;
        this.vlCorGrafico = vlCorGrafico;
        this.cdUnidade = cdUnidade;
        this.cdDescGrupoEquipamento = cdDescGrupoEquipamento;
        this.descGrupoEquipamento = descGrupoEquipamento;
    }

    public Long getCdGrupoEquipamento() {
        return cdGrupoEquipamento;
    }

    public void setCdGrupoEquipamento(Long cdGrupoEquipamento) {
        this.cdGrupoEquipamento = cdGrupoEquipamento;
    }

    public Integer getFgFrenteTrabalho() {
        return fgFrenteTrabalho;
    }

    public void setFgFrenteTrabalho(Integer fgFrenteTrabalho) {
        this.fgFrenteTrabalho = fgFrenteTrabalho;
    }

    public String getVlCorGrafico() {
        return vlCorGrafico;
    }

    public void setVlCorGrafico(String vlCorGrafico) {
        this.vlCorGrafico = vlCorGrafico;
    }

    public Integer getCdUnidade() {
        return cdUnidade;
    }

    public void setCdUnidade(Integer cdUnidade) {
        this.cdUnidade = cdUnidade;
    }

    public Long getCdDescGrupoEquipamento() {
        return cdDescGrupoEquipamento;
    }

    public void setCdDescGrupoEquipamento(Long cdDescGrupoEquipamento) {
        this.cdDescGrupoEquipamento = cdDescGrupoEquipamento;
    }

    public String getDescGrupoEquipamento() {
        return descGrupoEquipamento;
    }

    public void setDescGrupoEquipamento(String descGrupoEquipamento) {
        this.descGrupoEquipamento = descGrupoEquipamento;
    }
}
