package io.github.mrspock182.kafka.spring.messaging;

public interface MessagingProducer<T> {
    void send(T t);
}
