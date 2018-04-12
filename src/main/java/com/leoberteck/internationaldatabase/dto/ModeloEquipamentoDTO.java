package com.leoberteck.internationaldatabase.dto;

public class ModeloEquipamentoDTO {
    private Long cdModeloEquipamento;
    private Double vlEspacamento;
    private Integer cdIcone;
    private Double vlLargura;
    private Double vlComprimento;
    private Double vlCapacidade;
    private Long cdDescModeloEquipamento;
    private String descModeloEquipamento;

    public ModeloEquipamentoDTO(Long cdModeloEquipamento, Double vlEspacamento, Integer cdIcone, Double vlLargura, Double vlComprimento, Double vlCapacidade, Long cdDescModeloEquipamento, String descModeloEquipamento) {
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

    public Long getCdDescModeloEquipamento() {
        return cdDescModeloEquipamento;
    }

    public void setCdDescModeloEquipamento(Long cdDescModeloEquipamento) {
        this.cdDescModeloEquipamento = cdDescModeloEquipamento;
    }

    public String getDescModeloEquipamento() {
        return descModeloEquipamento;
    }

    public void setDescModeloEquipamento(String descModeloEquipamento) {
        this.descModeloEquipamento = descModeloEquipamento;
    }
}