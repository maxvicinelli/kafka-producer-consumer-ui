package com.example.maxmessaging.models;

public class DisplayFrontendInput {

    private String topic;

    private Integer offset;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return String.format("DisplayFrontEnd Object w/ topic:  " + topic + "\n offset: " + offset);
    }
}
