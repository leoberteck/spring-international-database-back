package com.leoberteck.internationaldatabase.resource;

import com.leoberteck.internationaldatabase.dto.ModeloEquipamentoDTO;
import com.leoberteck.internationaldatabase.entity.ModeloEquipamento;
import com.leoberteck.internationaldatabase.mapper.impl.ModeloEquipamentoMapper;
import com.leoberteck.internationaldatabase.repository.interfaces.ModeloEquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping("/modeloEquipamentos")
public class ModeloEquipamentoResource extends AbstractCrudDTOResource<ModeloEquipamentoDTO, ModeloEquipamento, Long>{

    @Autowired
    public ModeloEquipamentoResource(@Nonnull EntityManagerFactory entityManagerFactory, @Nonnull ModeloEquipamentoRepository repository, @Nonnull ModeloEquipamentoMapper mapper) {
        super(entityManagerFactory, repository, mapper);
    }
}
