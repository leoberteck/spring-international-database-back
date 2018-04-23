package com.leoberteck.internationaldatabase.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "CFG_LOCALES")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "lcid", scope = Long.class)
public class Locale {
    @Id
    @Column(name = "LCID")
    private Long lcid;
    @Column(name = "CODE", length = 5)
    private String code;
    @Column(name = "CHARSET", length = 45)
    private String charset;
    @ManyToOne
    @JoinColumn(name = "CD_DESCRICAO", referencedColumnName = "I18N")
    private I18N cdDescricao;
    @Column(name = "DESCRICAO")
    private String descricao;

    public Locale() { }

    public Locale(Long lcid, String code, String charset, I18N cdDescricao, String descricao) {
        this.lcid = lcid;
        this.code = code;
        this.charset = charset;
        this.cdDescricao = cdDescricao;
        this.descricao = descricao;
    }

    public Long getLcid() {
        return lcid;
    }

    public void setLcid(Long lcid) {
        this.lcid = lcid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public I18N getCdDescricao() {
        return cdDescricao;
    }

    public void setCdDescricao(I18N cdDescricao) {
        this.cdDescricao = cdDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Transient
    public String getDescricaoI18N(){
        return I18N.getTranslationOrDefault(getCdDescricao(), getDescricao());
    }
}
