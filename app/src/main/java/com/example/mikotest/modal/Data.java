package com.example.mikotest.modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data implements Parcelable {

    @SerializedName("TotalRecords")
    private String TotalRecords;

    @SerializedName("Records")
    private ArrayList<Records> recordsArrayList= new ArrayList<>();

    protected Data(Parcel in) {
        TotalRecords = in.readString();
        recordsArrayList = in.createTypedArrayList(Records.CREATOR);
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getTotalRecords ()
    {
        return TotalRecords;
    }

    public void setTotalRecords (String TotalRecords)
    {
        this.TotalRecords = TotalRecords;
    }

    public ArrayList<Records> getRecordsArrayList() {
        return recordsArrayList;
    }

    public void setRecordsArrayList(ArrayList<Records> recordsArrayList) {
        this.recordsArrayList = recordsArrayList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TotalRecords = "+TotalRecords+", Records = "+recordsArrayList+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TotalRecords);
        dest.writeTypedList(recordsArrayList);
    }
}
