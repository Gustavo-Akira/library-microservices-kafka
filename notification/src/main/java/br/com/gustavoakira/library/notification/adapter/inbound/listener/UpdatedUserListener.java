package br.com.gustavoakira.library.notification.adapter.inbound.listener;

import br.com.gustavoakira.library.common.adapters.event.UpdateUserEvent;
import br.com.gustavoakira.library.notification.adapter.outbound.mapper.UpdateUserEventToNotificationMapper;
import br.com.gustavoakira.library.notification.application.port.NotificationServicePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UpdatedUserListener {

    @Value("${topic.name.consumer}")
    private String topicName;

    private final NotificationServicePort servicePort;
    private final UpdateUserEventToNotificationMapper mapper;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "notification_id")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Update User event with key {} " ,payload.key());
        JsonMapper jsonMapper = new JsonMapper();
        try {
            UpdateUserEvent event = jsonMapper.readValue(payload.value(), UpdateUserEvent.class);
            servicePort.save(mapper.toNotification(event));
        } catch (JsonProcessingException e) {
            // Handle deserialization errors
            e.printStackTrace();
        }

    }

}
