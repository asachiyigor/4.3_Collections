package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок " + name + " не зарегистрирован. Игрок не может участвовать в турнире.");
    }
}