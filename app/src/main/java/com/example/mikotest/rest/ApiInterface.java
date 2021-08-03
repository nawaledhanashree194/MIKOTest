package com.example.mikotest.rest;

import com.example.mikotest.modal.Data;
import com.example.mikotest.modal.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

        @GET("testdata.json")
        Call<ResponseData> getRecords();
        
}
