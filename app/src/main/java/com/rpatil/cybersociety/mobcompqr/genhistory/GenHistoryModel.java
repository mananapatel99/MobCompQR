package com.rpatil.cybersociety.mobcompqr.genhistory;

import java.util.ArrayList;

public class GenHistoryModel {

    private String title;

    private String message;


    public GenHistoryModel(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public GenHistoryModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
