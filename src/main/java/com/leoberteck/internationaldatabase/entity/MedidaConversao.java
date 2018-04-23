package com.leoberteck.internationaldatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "CDT_MEDIDA_CONVERSAO")
public class MedidaConversao {
    @Id
    @Column(name = "CD_MEDIDA_CONVERSAO")
    private Long cdMedidaConversao;
    @ManyToOne
    @JoinColumn(name = "CD_MEDIDA_DE", referencedColumnName = "CD_MEDIDA")
    private Medida medidaDe;
    @ManyToOne
    @JoinColumn(name = "CD_MEDIDA_PARA", referencedColumnName = "CD_MEDIDA")
    private Medida medidaPara;
    @Column(name = "VL_INDICE_CONVERSAO", precision = 10, scale = 5)
    private Double vlIndiceConversao;

    public Long getCdMedidaConversao() {
        return cdMedidaConversao;
    }

    public void setCdMedidaConversao(Long cdMedidaConversao) {
        this.cdMedidaConversao = cdMedidaConversao;
    }

    public Medida getMedidaDe() {
        return medidaDe;
    }

    public void setMedidaDe(Medida medidaDe) {
        this.medidaDe = medidaDe;
    }

    public Medida getMedidaPara() {
        return medidaPara;
    }

    public void setMedidaPara(Medida medidaPara) {
        this.medidaPara = medidaPara;
    }

    public Double getVlIndiceConversao() {
        return vlIndiceConversao;
    }

    public void setVlIndiceConversao(Double vlIndiceConversao) {
        this.vlIndiceConversao = vlIndiceConversao;
    }
}
