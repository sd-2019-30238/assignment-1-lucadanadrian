package com.books.assignment3.request;

public class Request {
    private String requestName;
    private Object requestObject;

    public Request() {
    }

    public Request(String requestName, Object requestObject) {
        this.requestName = requestName;
        this.requestObject = requestObject;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public Object getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(Object requestObject) {
        this.requestObject = requestObject;
    }
}
