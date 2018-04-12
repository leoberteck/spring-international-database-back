package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.dto.GrupoEquipamentoDTO;
import com.leoberteck.internationaldatabase.entity.GrupoEquipamento;
import com.leoberteck.internationaldatabase.mapper.impl.GrupoEquipamentoMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.GrupoEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping("/grupoEquipamento")
public class GrupoEquipamentoResource extends AbstractCrudDTOResource<GrupoEquipamentoDTO, GrupoEquipamento, Long> {

    @Autowired
    public GrupoEquipamentoResource(EntityManagerFactory entityManagerFactory, @Nonnull GrupoEquipamentoRepository repository, @Nonnull GrupoEquipamentoMapper mapper) {
        super(entityManagerFactory, repository, mapper);
    }
}