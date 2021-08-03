package com.example.mikotest.modal;

import com.google.gson.annotations.SerializedName;

public class ResponseData {

    @SerializedName("Status")
    public int status;
    @SerializedName("Message")
    public String message;
    public Data data;

}
