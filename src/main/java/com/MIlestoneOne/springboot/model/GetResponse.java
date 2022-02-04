package com.MIlestoneOne.springboot.model;

public class GetResponse {
    private ResponseClass Data;
    private String status;

    public GetResponse(ResponseClass data, String message) {
        this.Data = data;
        this.status = message;
    }
    public GetResponse()
    {

    }

    public String getStatus() {
        return status;
    }

    public ResponseClass getData() {
        return Data;
    }
}
