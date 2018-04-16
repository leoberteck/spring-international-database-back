package com.leoberteck.internationaldatabase.repository.interfaces;

import com.leoberteck.internationaldatabase.entity.I18N;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface I18nRepository extends JpaRepository<I18N, Long> {
    @NotNull
    @Override
    @EntityGraph(value = "fullTranslate", type = EntityGraph.EntityGraphType.LOAD)
    Optional<I18N> findById(@NotNull Long aLong);
}
