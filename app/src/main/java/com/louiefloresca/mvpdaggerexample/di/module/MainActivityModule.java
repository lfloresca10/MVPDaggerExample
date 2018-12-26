package com.louiefloresca.mvpdaggerexample.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.louiefloresca.mvpdaggerexample.api.APIInterface;
import com.louiefloresca.mvpdaggerexample.data.Result;
import com.louiefloresca.mvpdaggerexample.di.qualifier.ActivityContext;
import com.louiefloresca.mvpdaggerexample.di.scope.ActivityScope;
import com.louiefloresca.mvpdaggerexample.ui.MainActivity;
import com.louiefloresca.mvpdaggerexample.ui.MainActivityAdapter;
import com.louiefloresca.mvpdaggerexample.ui.MainActivityContract;
import com.louiefloresca.mvpdaggerexample.ui.MainActivityPresenter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    public AppCompatActivity mainActivity;

    public Context context;

    private MainActivityContract.View mViewMain;


    public MainActivityModule(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    public MainActivityModule(AppCompatActivity activity, MainActivityContract.View view) {
        mainActivity = activity;
        mViewMain = view;
    }

    @Provides
    @ActivityScope
    AppCompatActivity providesMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    Context provideContext() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    LinearLayoutManager providesLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @ActivityScope
    MainActivityAdapter provideMainAdapter() {
        return new MainActivityAdapter(new ArrayList<Result.Data>());
    }


    @Provides
    @ActivityScope
    MainActivityPresenter provideMainPresenter(APIInterface apiService, MainActivityContract.View view){
        return new MainActivityPresenter(apiService, view);
    }

    @Provides
    @ActivityScope
    MainActivityContract.View providMainView(){
        return mViewMain;
    }

}
