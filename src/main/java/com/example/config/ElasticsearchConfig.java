package com.example.config;

import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {
    /**
     * The transport layer of the Elasticsearch client requires a json object mapper to
     * define how to serialize/deserialize java objects. The mapper can be customized by adding
     * modules, for example since the Article and Comment object both have Instant fields, the
     * JavaTimeModule is added to provide support for java 8 Time classes, which the mapper itself does
     * not support.
     */
    @Bean
    public JacksonJsonpMapper jacksonJsonpMapper(ObjectMapper objectMapper) {

//        ObjectMapper objectMapper = JsonMapper.builder()
//                .addModule(new JavaTimeModule())
//                .build();
        return new JacksonJsonpMapper(objectMapper);
    }
}
