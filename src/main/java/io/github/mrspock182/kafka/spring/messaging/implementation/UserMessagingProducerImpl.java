package io.github.mrspock182.kafka.spring.messaging.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mrspock182.kafka.spring.dto.User;
import io.github.mrspock182.kafka.spring.dto.UserKafkaResource;
import io.github.mrspock182.kafka.spring.messaging.MessagingProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagingProducerImpl implements MessagingProducer<User> {

    private final String topic;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    public UserMessagingProducerImpl(@Value("${kafka.topic.user}") String topic,
                                     ObjectMapper objectMapper,
                                     KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(final User user) {
        kafkaTemplate.send(topic, getJson(user));
    }

    private String getJson(final User user) {
        try {
            UserKafkaResource userKafkaResource = new UserKafkaResource(user);
            String value = objectMapper.writeValueAsString(userKafkaResource);
            return value;
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
