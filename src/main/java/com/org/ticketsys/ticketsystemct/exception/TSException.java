package com.org.ticketsys.ticketsystemct.exception;

public class TSException extends Exception {
    private String errorCode;
    private String errorMessage;
    private String errorDetail;

    // Constructor with all fields
    public TSException(String errorCode, String errorMessage, String errorDetail) {
        super(errorMessage); // Pass errorMessage to the superclass constructor
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    // Default constructor
    public TSException() {
        super();
    }

    // Constructor with error code and message only
    public TSException(String errorCode, String errorMessage) {
        super(errorMessage); // Pass errorMessage to the superclass constructor
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    // Constructor with error message only
    public TSException(String errorMessage) {
        super(errorMessage); // Pass errorMessage to the superclass constructor
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

    @Override
    public String toString() {
        return "TSException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorDetail='" + errorDetail + '\'' +
                '}';
    }
}

