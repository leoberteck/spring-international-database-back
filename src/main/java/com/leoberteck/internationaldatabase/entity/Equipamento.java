package com.leoberteck.internationaldatabase.entity;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "CDT_EQUIPAMENTO")
@SequenceGenerator(name = "SEQ_CDT_EQUIPAMENTO", sequenceName = "SEQ_CDT_EQUIPAMENTO", allocationSize = 1)
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CDT_EQUIPAMENTO")
    @Column(name = "CD_EQUIPAMENTO")
    private Long cdEquipamento;
    @Column(name = "CD_SERIE", length = 15)
    private String cdSerie;
    @Column(name = "CD_TURMA", length = 15)
    private String cdTurma;
    @Column(name = "CD_HR_PONTO_ELET")
    private Integer cdHrPontoElet;
    @Column(name = "CD_RELOGIO")
    private Integer cdRelogio;
    @Column(name = "FG_IMPLEMENTO_FIXO")
    private Integer fgImplementoFixo;
    @LastModifiedDate
    @Column(name = "DT_ULT_ALTERACAO")
    private ZonedDateTime dtUltAlteracao;
    @ManyToOne
    @JoinColumn(name = "CD_MODELO_EQUIPAMENTO")
    private ModeloEquipamento cdModeloEquipamento;
    @ManyToOne
    @JoinColumn(name = "CD_TP_EQUIPAMENTO")
    private TipoEquipamento cdTipoEquipamento;
    @ManyToOne
    @JoinColumn(name = "CD_GRUPO_EQUIPAMENTO")
    private GrupoEquipamento cdGrupoEquipamento;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_DESC_EQUIPAMENTO", referencedColumnName = "I18N")
    private I18N cdDescEquipamento;
    @Column(name = "DESC_EQUIPAMENTO")
    private String descEquipamento;

    public Equipamento() { }

    public Equipamento(Long cdEquipamento, String cdSerie, String cdTurma, Integer cdHrPontoElet, Integer cdRelogio, Integer fgImplementoFixo, ZonedDateTime dtUltAlteracao, ModeloEquipamento cdModeloEquipamento, TipoEquipamento cdTipoEquipamento, GrupoEquipamento cdGrupoEquipamento, I18N cdDescEquipamento, String descEquipamento) {
        this.cdEquipamento = cdEquipamento;
        this.cdSerie = cdSerie;
        this.cdTurma = cdTurma;
        this.cdHrPontoElet = cdHrPontoElet;
        this.cdRelogio = cdRelogio;
        this.fgImplementoFixo = fgImplementoFixo;
        this.dtUltAlteracao = dtUltAlteracao;
        this.cdModeloEquipamento = cdModeloEquipamento;
        this.cdTipoEquipamento = cdTipoEquipamento;
        this.cdGrupoEquipamento = cdGrupoEquipamento;
        this.cdDescEquipamento = cdDescEquipamento;
        this.descEquipamento = descEquipamento;
    }

    public Long getCdEquipamento() {
        return cdEquipamento;
    }

    public void setCdEquipamento(Long cdEquipamento) {
        this.cdEquipamento = cdEquipamento;
    }

    public String getCdSerie() {
        return cdSerie;
    }

    public void setCdSerie(String cdSerie) {
        this.cdSerie = cdSerie;
    }

    public String getCdTurma() {
        return cdTurma;
    }

    public void setCdTurma(String cdTurma) {
        this.cdTurma = cdTurma;
    }

    public Integer getCdHrPontoElet() {
        return cdHrPontoElet;
    }

    public void setCdHrPontoElet(Integer cdHrPontoElet) {
        this.cdHrPontoElet = cdHrPontoElet;
    }

    public Integer getCdRelogio() {
        return cdRelogio;
    }

    public void setCdRelogio(Integer cdRelogio) {
        this.cdRelogio = cdRelogio;
    }

    public Integer getFgImplementoFixo() {
        return fgImplementoFixo;
    }

    public void setFgImplementoFixo(Integer fgImplementoFixo) {
        this.fgImplementoFixo = fgImplementoFixo;
    }

    public ZonedDateTime getDtUltAlteracao() {
        return dtUltAlteracao;
    }

    public void setDtUltAlteracao(ZonedDateTime dtUltAlteracao) {
        this.dtUltAlteracao = dtUltAlteracao;
    }

    public ModeloEquipamento getCdModeloEquipamento() {
        return cdModeloEquipamento;
    }

    public void setCdModeloEquipamento(ModeloEquipamento cdModeloEquipamento) {
        this.cdModeloEquipamento = cdModeloEquipamento;
    }

    public TipoEquipamento getCdTipoEquipamento() {
        return cdTipoEquipamento;
    }

    public void setCdTipoEquipamento(TipoEquipamento cdTipoEquipamento) {
        this.cdTipoEquipamento = cdTipoEquipamento;
    }

    public GrupoEquipamento getCdGrupoEquipamento() {
        return cdGrupoEquipamento;
    }

    public void setCdGrupoEquipamento(GrupoEquipamento cdGrupoEquipamento) {
        this.cdGrupoEquipamento = cdGrupoEquipamento;
    }

    public I18N getCdDescEquipamento() {
        return cdDescEquipamento;
    }

    public void setCdDescEquipamento(I18N cdDescEquipamento) {
        this.cdDescEquipamento = cdDescEquipamento;
    }

    public String getDescEquipamento() {
        return descEquipamento;
    }

    public void setDescEquipamento(String descEquipamento) {
        this.descEquipamento = descEquipamento;
    }

    @Transient
    public String getDescEquipamentoI18N(){
        return I18N.getTranslationOrDefault(getCdDescEquipamento(), getDescEquipamento());
    }
}
