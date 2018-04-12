package com.leoberteck.internationaldatabase.mapper.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

public interface BaseMapper<ETY, DTO> {
    DTO convertBack(ETY ety);
    ETY convert(DTO dto);

    default List<ETY> convert(@Nullable Iterable<DTO> iterable) {
        List<ETY> list = new ArrayList<>();
        assert iterable != null;
        for (DTO s : iterable) {
            list.add(convert(s));
        }
        return list;
    }

    default List<DTO> convertBack(@Nullable Iterable<ETY> iterable) {
        List<DTO> list = new ArrayList<>();
        assert iterable != null;
        for (ETY ety : iterable) {
            list.add(convertBack(ety));
        }
        return list;
    }

    default Page<DTO> convertPage(Page<ETY> etyPage, Pageable pageable){
        List<DTO> dtoContent = convertBack(etyPage.getContent());
        return new PageImpl<>(dtoContent, pageable, etyPage.getTotalElements());
    }
}
