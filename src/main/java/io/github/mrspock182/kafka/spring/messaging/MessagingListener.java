package io.github.mrspock182.kafka.spring.messaging;

public interface MessagingListener<T> {
    void read(T t);
}
