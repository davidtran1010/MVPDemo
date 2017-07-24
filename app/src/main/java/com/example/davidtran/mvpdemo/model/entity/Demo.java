package com.example.davidtran.mvpdemo.model.entity;

/**
 * Created by davidtran on 7/24/17.
 */

public class Demo {
    private String message;

    public Demo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Demo{ message = "+ message+"}";
    }
}
