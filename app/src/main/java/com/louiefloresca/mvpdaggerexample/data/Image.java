package com.louiefloresca.mvpdaggerexample.data;

import com.google.gson.annotations.SerializedName;

public class Image {

    public Preview getPreview() {
        return preview;
    }

    @SerializedName("fixed_width")
    private Preview preview;

    public class Preview {
        public String getUrl() {
            return url;
        }

        public String getWidth() {
            return width;
        }

        public String getHeight() {
            return height;
        }

        public String getMp4() {
            return mp4;
        }

        public String getMp4_size() {
            return mp4_size;
        }

        private String url;
        private String width;
        private String height;
        private String mp4;
        private String mp4_size;
    }
}
