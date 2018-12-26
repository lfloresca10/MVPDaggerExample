package com.louiefloresca.mvpdaggerexample.ui;

import com.louiefloresca.mvpdaggerexample.api.APIInterface;
import com.louiefloresca.mvpdaggerexample.data.Result;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private APIInterface apiService;

    private MainActivityContract.View view;

    @Inject
    public MainActivityPresenter(APIInterface apiService, MainActivityContract.View view) {
        this.apiService = apiService;
        this.view = view;
    }


    @Override
    public void getTrendingGiphy(String apiKey, int limit, int offset) {
        apiService.getGiphyTrending(apiKey, limit, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        view.success(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.error(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
