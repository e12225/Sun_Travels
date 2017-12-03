package com.codegen.suntravels.entityResponses;

/**
 * Created by DELL on 12/2/2017.
 */
public class AddEntityResponse {

    boolean insertingStatus;
    Object entity;
    String message;

    public boolean getInsertingStatus() {
        return insertingStatus;
    }

    public void setInsertingStatus(boolean insertingStatus) {
        this.insertingStatus = insertingStatus;
    }

    public boolean isInsertingStatus() {
        return insertingStatus;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
