package com.leoberteck.internationaldatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "CDT_MEDIDA")
public class Medida {

    @Id
    @Column(name = "CD_MEDIDA")
    private Long cdMedida;
    @ManyToOne
    @JoinColumn(name = "CD_SIMBOLO", referencedColumnName = "I18N")
    private I18N cdSimbolo;
    @ManyToOne
    @JoinColumn(name = "CD_DESCRICAO", referencedColumnName = "I18N")
    private I18N cdDescricao;

    public Long getCdMedida() {
        return cdMedida;
    }

    public void setCdMedida(Long cdMedida) {
        this.cdMedida = cdMedida;
    }

    public I18N getCdSimbolo() {
        return cdSimbolo;
    }

    public void setCdSimbolo(I18N cdSimbolo) {
        this.cdSimbolo = cdSimbolo;
    }

    public I18N getCdDescricao() {
        return cdDescricao;
    }

    public void setCdDescricao(I18N cdDescricao) {
        this.cdDescricao = cdDescricao;
    }

    @Transient
    public String getSimboloI18n(){
        return I18N.getTranslationOrDefault(cdSimbolo, null);
    }

    @Transient
    public String getDescricaoI18n(){
        return I18N.getTranslationOrDefault(cdDescricao, null);
    }
}
