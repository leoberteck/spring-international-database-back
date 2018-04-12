package com.leoberteck.internationaldatabase.repository.interfaces;

import com.leoberteck.internationaldatabase.entity.Locale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocaleRepository extends JpaRepository<Locale, Long> {}
