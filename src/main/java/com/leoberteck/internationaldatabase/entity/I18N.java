package com.leoberteck.internationaldatabase.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "SEQ_I18N", sequenceName = "SEQ_I18N", allocationSize = 1)
@Table(name = "I18N")
@NamedEntityGraph(name="translationWithFilter", attributeNodes = {
    @NamedAttributeNode("traducaoList")
})
@FilterDef(name = "localeFilter", parameters = {
        @ParamDef(name = "locale", type = "long")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "i18N")
public class I18N {

    public static String getTranslationOrDefault(I18N i18N, String def){
        if(i18N != null
                && i18N.getTraducaoList() != null
                && i18N.getTraducaoList().size() > 0){
            return i18N.getTraducaoList().get(0).getDescValor();
        } else {
            return def;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_I18N")
    private Long I18N;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Traducao.class, mappedBy = "cdI18n")
    @Filter(name = "localeFilter", condition = "CD_LOCALE = :locale" )
    private List<Traducao> traducaoList;

    public Long getI18N() {
        return I18N;
    }

    public void setI18N(Long i18N) {
        I18N = i18N;
    }

    public List<Traducao> getTraducaoList() {
        return traducaoList;
    }

    public void setTraducaoList(List<Traducao> traducaoList) {
        this.traducaoList = traducaoList;
    }

}
