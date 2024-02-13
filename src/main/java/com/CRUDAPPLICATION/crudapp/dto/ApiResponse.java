package com.CRUDAPPLICATION.crudapp.dto;

import java.util.Date;

public class ApiResponse {
    private String status;
    private Date apiTimeStamp;
    private String path;
    private Object data;
    private Object error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApiTimeStamp() {
        return apiTimeStamp;
    }

    public void setApiTimeStamp(Date apiTimeStamp) {
        this.apiTimeStamp = apiTimeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
