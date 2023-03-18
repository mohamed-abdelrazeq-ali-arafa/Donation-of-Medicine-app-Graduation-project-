package com.medicalsystem.Medical.service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Response<t> {

    private t data;
    String error;

    private boolean isSuccess;


    public t getData() {
        return data;
    }


    public String getArr() {
        return error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void sucess(t data) {
        this.data = data;
        isSuccess = true;
        this.error = null;

    }

    public void failure(String error) {
        isSuccess = false;
        this.error = error;

    }

    public void make(String msg, int code, t data) {

        if (code == 400) {
            failure(msg);
        } else {
            sucess(data);
        }

    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.sucess(data);
        return response;
    }

    public static <T> Response<T> failed(String error) {
        Response<T> response = new Response<>();
        response.failure(error);
        return response;
    }
}

