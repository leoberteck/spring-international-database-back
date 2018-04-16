package com.leoberteck.internationaldatabase.mapper.impl;

import com.leoberteck.internationaldatabase.mapper.interfaces.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class EchoMapper<ETY> implements BaseMapper<ETY, ETY> {

    @Override
    public ETY convertBack(ETY ety) {
        return ety;
    }

    @Override
    public ETY convert(ETY ety) {
        return ety;
    }
}
