package com.leoberteck.internationaldatabase.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SEQ_CDT_MODELO_EQUIPAMENTO", sequenceName = "SEQ_CDT_MODELO_EQUIPAMENTO", allocationSize = 1)
@Table(name = "CDT_MODELO_EQUIPAMENTO")
public class ModeloEquipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CDT_MODELO_EQUIPAMENTO")
    @Column(name = "CD_MODELO_EQUIPAMENTO")
    private Long cdModeloEquipamento;
    @Column(name = "VL_ESPACAMENTO", precision = 10, scale = 2)
    private Double vlEspacamento;
    @Column(name = "CD_ICONE")
    private Integer cdIcone;
    @Column(name = "VL_LARGURA", precision = 10, scale = 2)
    private Double vlLargura;
    @Column(name = "VL_COMPRIMENTO", precision = 10, scale = 2)
    private Double vlComprimento;
    @Column(name = "VL_CAPACIDADE", precision = 10, scale = 2)
    private Double vlCapacidade;
    @ManyToOne
    @JoinColumn(name = "CD_DESC_MODELO_EQUIPAMENTO", referencedColumnName = "I18N")
    private I18N cdDescModeloEquipamento;
    @Column(name = "DESC_MODELO_EQUIPAMENTO")
    private String descModeloEquipamento;

    public ModeloEquipamento(Long cdModeloEquipamento, Double vlEspacamento, Integer cdIcone, Double vlLargura, Double vlComprimento, Double vlCapacidade, I18N cdDescModeloEquipamento, String descModeloEquipamento) {
        this.cdModeloEquipamento = cdModeloEquipamento;
        this.vlEspacamento = vlEspacamento;
        this.cdIcone = cdIcone;
        this.vlLargura = vlLargura;
        this.vlComprimento = vlComprimento;
        this.vlCapacidade = vlCapacidade;
        this.cdDescModeloEquipamento = cdDescModeloEquipamento;
        this.descModeloEquipamento = descModeloEquipamento;
    }

    public Long getCdModeloEquipamento() {
        return cdModeloEquipamento;
    }

    public void setCdModeloEquipamento(Long cdModeloEquipamento) {
        this.cdModeloEquipamento = cdModeloEquipamento;
    }

    public Double getVlEspacamento() {
        return vlEspacamento;
    }

    public void setVlEspacamento(Double vlEspacamento) {
        this.vlEspacamento = vlEspacamento;
    }

    public Integer getCdIcone() {
        return cdIcone;
    }

    public void setCdIcone(Integer cdIcone) {
        this.cdIcone = cdIcone;
    }

    public Double getVlLargura() {
        return vlLargura;
    }

    public void setVlLargura(Double vlLargura) {
        this.vlLargura = vlLargura;
    }

    public Double getVlComprimento() {
        return vlComprimento;
    }

    public void setVlComprimento(Double vlComprimento) {
        this.vlComprimento = vlComprimento;
    }

    public Double getVlCapacidade() {
        return vlCapacidade;
    }

    public void setVlCapacidade(Double vlCapacidade) {
        this.vlCapacidade = vlCapacidade;
    }

    public I18N getCdDescModeloEquipamento() {
        return cdDescModeloEquipamento;
    }

    public void setCdDescModeloEquipamento(I18N cdDescModeloEquipamento) {
        this.cdDescModeloEquipamento = cdDescModeloEquipamento;
    }

    public String getDescModeloEquipamento() {
        return descModeloEquipamento;
    }

    public void setDescModeloEquipamento(String descModeloEquipamento) {
        this.descModeloEquipamento = descModeloEquipamento;
    }

    @Transient
    public String getDescModeloEquipamentoI18N(){
        return I18N.getTranslationOrDefault(getCdDescModeloEquipamento(), getDescModeloEquipamento());
    }
}