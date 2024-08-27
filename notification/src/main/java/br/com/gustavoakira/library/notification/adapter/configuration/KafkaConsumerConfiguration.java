package br.com.gustavoakira.library.notification.adapter.configuration;

import br.com.gustavoakira.library.common.adapters.event.UpdateUserEvent;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

        @Value("${spring.kafka.bootstrap-servers}")
        private String server;

        @Value("${spring.kafka.consumer.properties.spring.json.value.default.type}")
        private String type;
        @Bean
        public ConsumerFactory<String, String> consumerFactory() {
            Map<String, Object> configProps = new HashMap<>();
            configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
            configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            return new DefaultKafkaConsumerFactory<>(configProps);
        }

}
