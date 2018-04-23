package com.leoberteck.internationaldatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "CDT_SISTEMA_METRICO")
public class SistemaMetrico {
    @Id
    @Column(name = "CD_SISTEMA_METRICO")
    private Long cdSistemaMetrico;
    @ManyToOne
    @JoinColumn(name = "CD_DESCRICAO", referencedColumnName = "I18N")
    private I18N descricao;

    public Long getCdSistemaMetrico() {
        return cdSistemaMetrico;
    }

    public void setCdSistemaMetrico(Long cdSistemaMetrico) {
        this.cdSistemaMetrico = cdSistemaMetrico;
    }

    public I18N getDescricao() {
        return descricao;
    }

    public void setDescricao(I18N descricao) {
        this.descricao = descricao;
    }
}
