package com.leaf.cloud.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.leaf.cloud.handler.CustomIdentifierGenerator;
import com.leaf.cloud.handler.CustomInterceptor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class MybatisPlusConfig {

    /**
     * 创建一个MybatisPlusInterceptor的Bean，用于配置Mybatis-Plus的拦截器
     *
     * @return 返回配置好的MybatisPlusInterceptor对象
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new CustomInterceptor());
        return interceptor;
    }


    /**
     * 定义一个Bean，用于生成唯一标识符
     *
     * @return 返回一个自定义的标识符生成器实例
     */
    @Bean
    public IdentifierGenerator idGenerator() {
        return new CustomIdentifierGenerator();
    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> {
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        };
    }
}
