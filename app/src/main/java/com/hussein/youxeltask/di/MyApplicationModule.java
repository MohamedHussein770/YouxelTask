package com.hussein.youxeltask.di;

import com.hussein.youxeltask.app.MyApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class MyApplicationModule {

  private final MyApplication myApplication;

  public MyApplicationModule(MyApplication myApplication) {
    this.myApplication = myApplication;
  }

  @Singleton
  @Provides
  MyApplication provideMyApplication() {
    return myApplication;
  }
}