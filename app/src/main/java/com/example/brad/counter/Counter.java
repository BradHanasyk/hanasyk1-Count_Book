package com.example.brad.counter;

import java.util.Date;

//Class definition for main counter class


public class Counter {

    private String name;
    private Integer initial_count;
    private String comment;
    private int current_count;
    private Date date;


    public Counter(String name, Integer initial_count) {
        this.name = name;
        this.initial_count = initial_count;
    }

    public Counter(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public Counter(String name, Integer initial_count, String comment, int current_count) {
        this.name = name;
        this.initial_count = initial_count;
        this.comment = comment;
        this.current_count = current_count;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getInitialCount() {
        return initial_count;
    }
    public void setInitialCount(Integer initial_count) {
        this.initial_count = initial_count;
    }
    public int current_count() {
        return current_count;
    }
    public void setCurrent_count(int count){
        count = initial_count;
        this.current_count = count;
    }
    public int getCurrent_count() {return current_count;}


}