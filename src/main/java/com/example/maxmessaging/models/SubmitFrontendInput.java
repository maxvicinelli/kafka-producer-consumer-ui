package com.example.maxmessaging.models;


public class SubmitFrontendInput {

    private String topic;
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public String getCombinedMsg() {
        return String.format(topic + ";" + input);
    }

    @Override
    public String toString() {
        return String.format("FrontendInput with input: " + this.input + "\n and topic: " + this.topic);
    }
}
