package com.louiefloresca.mvpdaggerexample.di.component;

import com.louiefloresca.mvpdaggerexample.di.module.MainActivityModule;
import com.louiefloresca.mvpdaggerexample.di.scope.ActivityScope;
import com.louiefloresca.mvpdaggerexample.ui.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity activity);
}
