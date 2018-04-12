package com.leoberteck.internationaldatabase.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SEQ_CDT_GRUPO_EQUIPAMENTO", sequenceName = "SEQ_CDT_GRUPO_EQUIPAMENTO", allocationSize = 1)
@Table(name = "CDT_GRUPO_EQUIPAMENTO")
public class GrupoEquipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CDT_GRUPO_EQUIPAMENTO")
    @Column(name = "CD_GRUPO_EQUIPAMENTO")
    private Long cdGrupoEquipamento;
    @Column(name = "FG_FRENTE_TRABALHO")
    private Integer fgFrenteTrabalho;
    @Column(name = "VL_COR_GRAFICO")
    private String vlCorGrafico;
    @Column(name = "CD_UNIDADE")
    private Integer cdUnidade;
    @ManyToOne
    @JoinColumn(name = "CD_DESC_GRUPO_EQUIPAMENTO", referencedColumnName = "I18N")
    private I18N cdDescGrupoEquipamento;
    @Column(name = "DESC_GRUPO_EQUIPAMENTO")
    private String descGrupoEquipamento;

    public GrupoEquipamento() {
    }

    public GrupoEquipamento(Long cdGrupoEquipamento, Integer fgFrenteTrabalho, String vlCorGrafico, Integer cdUnidade, I18N cdDescGrupoEquipamento, String descGrupoEquipamento) {
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

    public I18N getCdDescGrupoEquipamento() {
        return cdDescGrupoEquipamento;
    }

    public void setCdDescGrupoEquipamento(I18N cdDescGrupoEquipamento) {
        this.cdDescGrupoEquipamento = cdDescGrupoEquipamento;
    }

    public String getDescGrupoEquipamento() {
        return descGrupoEquipamento;
    }

    public void setDescGrupoEquipamento(String descGrupoEquipamento) {
        this.descGrupoEquipamento = descGrupoEquipamento;
    }

    @Transient
    public String getDescGrupoEquipamentoI18N(){
        return I18N.getTranslationOrDefault(getCdDescGrupoEquipamento(), getDescGrupoEquipamento());
    }
}
