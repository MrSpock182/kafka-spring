package io.github.mrspock182.kafka.spring.messaging.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mrspock182.kafka.spring.dto.UserKafkaResource;
import io.github.mrspock182.kafka.spring.messaging.MessagingListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserMessagingListenerImpl implements MessagingListener<String> {

    private final ObjectMapper objectMapper;

    public UserMessagingListenerImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = "${kafka.topic.user}")
    public void read(final String message) {
        try {
            final UserKafkaResource userKafkaResource = objectMapper.readValue(message, UserKafkaResource.class);
            System.out.println(userKafkaResource.toString());
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
}
