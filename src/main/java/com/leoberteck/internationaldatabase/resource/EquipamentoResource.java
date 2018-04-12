package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.dto.EquipamentoDTO;
import com.leoberteck.internationaldatabase.entity.Equipamento;
import com.leoberteck.internationaldatabase.mapper.impl.EquipamentoMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoResource extends AbstractCrudDTOResource<EquipamentoDTO, Equipamento, Long> {

    private EntityManager entityManager;

    @Autowired
    public EquipamentoResource(EntityManagerFactory entityManagerFactory, @Nonnull EquipamentoRepository repository, @Nonnull EquipamentoMapper mapper) {
        super(entityManagerFactory, repository, mapper);
        this.entityManager = entityManager;
    }
}
