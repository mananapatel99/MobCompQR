package com.rpatil.cybersociety.mobcompqr.scanhistory;

import java.util.ArrayList;

public class ScanHistoryModel {

    private String title;

    private String message;


    public ScanHistoryModel(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public ScanHistoryModel() {

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
