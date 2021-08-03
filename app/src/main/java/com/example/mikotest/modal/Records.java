package com.example.mikotest.modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Records implements Parcelable {

    @SerializedName("Id")
    private transient int id;
    @SerializedName("title")
    private String title;
    @SerializedName("shortDescription")
    private String shortDescription;
    @SerializedName("collectedValue")
    private int collectedValue;
    @SerializedName("totalValue")
    private int totalValue;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;
    @SerializedName("mainImageURL")
    private String mainImageURL;

    public Records(int id, String title, String shortDescription,
                   int collectedValue, int totalValue, String startDate,
                   String endDate, String mainImageURL) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.collectedValue = collectedValue;
        this.totalValue = totalValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mainImageURL = mainImageURL;
    }

    protected Records(Parcel in) {
        id = in.readInt();
        title = in.readString();
        shortDescription = in.readString();
        collectedValue = in.readInt();
        totalValue = in.readInt();
        startDate = in.readString();
        endDate = in.readString();
        mainImageURL = in.readString();
    }

    public static final Creator<Records> CREATOR = new Creator<Records>() {
        @Override
        public Records createFromParcel(Parcel in) {
            return new Records(in);
        }

        @Override
        public Records[] newArray(int size) {
            return new Records[size];
        }
    };


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getCollectedValue() {
        return collectedValue;
    }

    public void setCollectedValue(int collectedValue) {
        this.collectedValue = collectedValue;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMainImageURL() {
        return mainImageURL;
    }

    public void setMainImageURL(String mainImageURL) {
        this.mainImageURL = mainImageURL;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", collectedValue=" + collectedValue +
                ", totalValue=" + totalValue +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", mainImageURL='" + mainImageURL + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(shortDescription);
        dest.writeInt(collectedValue);
        dest.writeInt(totalValue);
        dest.writeString(startDate);
        dest.writeString(endDate);
        dest.writeString(mainImageURL);
    }
}
