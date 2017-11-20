package com.company.shop.model;


public class ResponseMessage {

    private String status;
    private String errorMessage;

    private ResponseMessage(String status) {
        this.status = status;
    }

    private ResponseMessage(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public static ResponseMessage okMessage() {
        return new ResponseMessage("OK");
    }

    public static ResponseMessage errorMessage(String message) {
        return new ResponseMessage("ERROR", message);
    }

    public String getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "status='" + status + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
