package com.leoberteck.internationaldatabase.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SEQ_TRADUCAO", sequenceName = "SEQ_TRADUCAO", allocationSize = 1)
@Table(name = "TRADUCAO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cdId")
public class Traducao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRADUCAO")
    @Column(name = "CD_ID")
    private Long cdId;
    @Column(name = "DESC_VALOR", length = 1000)
    private String descValor;
    @ManyToOne
    @JoinColumn(name = "CD_I18N", referencedColumnName = "I18N", nullable = false)
    private I18N cdI18n;
    @ManyToOne
    @JoinColumn(name = "CD_LOCALE", referencedColumnName = "LCID")
    private Locale cdLocale;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public String getDescValor() {
        return descValor;
    }

    public void setDescValor(String descValor) {
        this.descValor = descValor;
    }

    public I18N getCdI18n() {
        return cdI18n;
    }

    public void setCdI18n(I18N cdI18n) {
        this.cdI18n = cdI18n;
    }

    public Locale getCdLocale() {
        return cdLocale;
    }

    public void setCdLocale(Locale cdLocale) {
        this.cdLocale = cdLocale;
    }
}
