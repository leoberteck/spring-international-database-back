package com.leoberteck.internationaldatabase.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SEQ_CDT_TIPO_EQUIPAMENTO", sequenceName = "SEQ_CDT_TIPO_EQUIPAMENTO", allocationSize = 1)
@Table(name = "CDT_TIPO_EQUIPAMENTO")
public class TipoEquipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CDT_TIPO_EQUIPAMENTO")
    @Column(name = "CD_TP_EQUIPAMENTO")
    private Long cdTpEquipamento;
    @ManyToOne
    @JoinColumn(name = "cdDescTpEquipamento", referencedColumnName = "I18N")
    private I18N cdDescTpEquipamento;
    @Column(name = "DESC_TP_EQUIPAMENTO")
    private String descTpEquipamento;

    public Long getCdTpEquipamento() {
        return cdTpEquipamento;
    }

    public void setCdTpEquipamento(Long cdTpEquipamento) {
        this.cdTpEquipamento = cdTpEquipamento;
    }

    public I18N getCdDescTpEquipamento() {
        return cdDescTpEquipamento;
    }

    public void setCdDescTpEquipamento(I18N cdDescTpEquipamento) {
        this.cdDescTpEquipamento = cdDescTpEquipamento;
    }

    public String getDescTpEquipamento() {
        return descTpEquipamento;
    }

    public void setDescTpEquipamento(String descTpEquipamento) {
        this.descTpEquipamento = descTpEquipamento;
    }

    @Transient
    public String getDescTpEquipamentoI18N(){
        return I18N.getTranslationOrDefault(getCdDescTpEquipamento(), getDescTpEquipamento());
    }
}
