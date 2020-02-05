package com.hussein.youxeltask.di;

import com.hussein.youxeltask.data.remote.data_source.LiveMatchesRemoteDataSource;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RepositoryModule {

  @Provides
  static LiveMatchesRemoteDataSource provideMoviesRemoteDataSource() {
    return new LiveMatchesRemoteDataSource();
  }
}