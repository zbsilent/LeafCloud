package com.leaf.cloud.handler;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import java.util.UUID;

public class CustomIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        // 可根据具体需求生成自定义的数值型主键
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        return UUID.randomUUID().toString();
    }
}