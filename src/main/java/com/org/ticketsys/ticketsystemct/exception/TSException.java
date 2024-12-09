package com.org.ticketsys.ticketsystemct.exception;

public class TSException  extends Exception{
    private String errorCode;
    private String errorMessage;
    private String errorDetail;

    public TSException(String errorCode, String errorMessage, String errorDetail) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;

    }
    public TSException() {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
