package br.com.gustavoakira.library.users.adapters.outbound.producer;

import br.com.gustavoakira.library.common.adapters.event.UpdateUserEvent;
import br.com.gustavoakira.library.users.adapters.dto.UpdateUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UpdatedUserInformationProducer {

    private final KafkaTemplate<String, UpdateUserEvent> kafkaTemplate;
    @Value("${topic.name.producer}")
    private String topicName;

    public UpdatedUserInformationProducer(KafkaTemplate<String, UpdateUserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UpdateUserEvent event){

        final CompletableFuture<SendResult<String, UpdateUserEvent>> send = kafkaTemplate.send(topicName, event);
        send.whenComplete((result,ex)->{
           if(ex == null){
               log.info("Payload enviado: {} with offset {}",event,result.getRecordMetadata().offset());

           }else{
               log.error("Error sending the message {}", ex.getMessage());
           }
        });
    }


}
