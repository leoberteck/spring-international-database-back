package com.leoberteck.internationaldatabase.dto;

public class LocaleDTO {
    private Long lcid;
    private String code;
    private String charset;
    private Long cdDescricao;
    private String descricao;

    public LocaleDTO(Long lcid, String code, String charset, Long cdDescricao, String descricao) {
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

    public Long getCdDescricao() {
        return cdDescricao;
    }

    public void setCdDescricao(Long cdDescricao) {
        this.cdDescricao = cdDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
