package br.com.gustavoakira.library.notification.adapter.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

        @Value("spring.kafka.bootstrap-servers")
        private String server;
        @Bean
        public ConsumerFactory<String, String> consumerFactory() {
            Map<String, Object> configProps = new HashMap<>();
            configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
            configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
            configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"notification_id");

            return new DefaultKafkaConsumerFactory<>(configProps);
        }

}
