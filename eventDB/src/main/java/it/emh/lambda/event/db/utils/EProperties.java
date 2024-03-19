package it.emh.lambda.event.db.utils;

import lombok.Getter;

@Getter
public enum EProperties {
    DB_NAME("db.name"),
    DB_HOSTNAME("db.hostname"),
    DB_USERNAME("db.username"),
    DB_PASSWORD("db.password"),
    DB_PROTOCOL("db.protocol"),
    DB_PORT("db.port");

    private final String chiave;

    EProperties(String chiave) {
        this.chiave = chiave;
    }
}
