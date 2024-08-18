package br.com.gustavoakira.library.users.adapters.outbound.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdatedUserInformationProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.name.producer}")
    private String topicName;

    public UpdatedUserInformationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        log.info("Payload enviado: {}",message);
        kafkaTemplate.send(topicName, message);
    }
}
