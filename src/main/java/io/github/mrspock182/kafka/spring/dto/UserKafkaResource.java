package io.github.mrspock182.kafka.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public class UserKafkaResource {
    private String id;
    private String nome;
    private String city;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    public UserKafkaResource() {
    }

    public UserKafkaResource(User user) {
        this.id = UUID.randomUUID().toString();
        this.nome = user.getName();
        this.city = user.getCity();
        this.date = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "UserKafkaResource{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", city='" + city + '\'' +
                ", date=" + date +
                '}';
    }
}
