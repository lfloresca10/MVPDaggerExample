package com.louiefloresca.mvpdaggerexample.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("data")
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public class Data {

        public Image getImages() {
            return images;
        }

        private Image images;

    }
}
