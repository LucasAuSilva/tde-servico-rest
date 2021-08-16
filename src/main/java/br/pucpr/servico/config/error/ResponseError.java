package br.pucpr.servico.config.error;

import org.springframework.http.HttpStatus;

public class ResponseError {

    private int status;
    private String name;
    private String message;

    public ResponseError(HttpStatus status, String message) {
        this.status = status.value();
        this.name = status.name();
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
