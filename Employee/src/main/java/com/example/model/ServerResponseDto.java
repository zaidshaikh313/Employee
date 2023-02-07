package com.example.model;

public class ServerResponseDto {
    private String string;
    private Object object;

    public ServerResponseDto(String string, Object object) {
        this.string = string;
        this.object = object;
    }

    public ServerResponseDto(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
