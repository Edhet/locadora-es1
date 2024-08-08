package com.ablhds.app.domain;

public abstract class Persistent {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
