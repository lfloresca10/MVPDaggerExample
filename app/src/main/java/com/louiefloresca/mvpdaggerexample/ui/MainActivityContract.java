package com.louiefloresca.mvpdaggerexample.ui;

import com.louiefloresca.mvpdaggerexample.data.Result;

public interface MainActivityContract {

    interface View {
        void success(Result message);

        void error(String error);
    }

    interface Presenter {
        void getTrendingGiphy(String apiKey, int limit, int offset);
    }
}
