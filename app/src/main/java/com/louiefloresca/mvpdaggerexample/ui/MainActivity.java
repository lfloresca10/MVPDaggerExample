package com.louiefloresca.mvpdaggerexample.ui;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.louiefloresca.mvpdaggerexample.MvpDaggerApp;
import com.louiefloresca.mvpdaggerexample.R;
import com.louiefloresca.mvpdaggerexample.api.APIInterface;
import com.louiefloresca.mvpdaggerexample.data.Image;
import com.louiefloresca.mvpdaggerexample.data.Result;
import com.louiefloresca.mvpdaggerexample.di.component.DaggerMainActivityComponent;
import com.louiefloresca.mvpdaggerexample.di.component.MainActivityComponent;
import com.louiefloresca.mvpdaggerexample.di.module.MainActivityModule;
import com.louiefloresca.mvpdaggerexample.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject
    APIInterface mApiInterface;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    public MainActivityComponent mainActivityComponent;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    MainActivityPresenter mPresenter;

    @Inject
    MainActivityAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityComponent = DaggerMainActivityComponent.builder()
                 .mainActivityModule(new MainActivityModule(this, this))
                .applicationComponent(((MvpDaggerApp) getApplication())
                        .getComponent()).build();

        mainActivityComponent.inject(this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mPresenter.getTrendingGiphy(Constants.API_KEY, 10, 0);

        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        List<Result.Data> testData = new ArrayList<>();

        mAdapter.addItems(testData);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void success(Result message) {
        mAdapter.addItems(message.getData());
    }

    @Override
    public void error(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
