package com.hussein.youxeltask.data.repo;

import com.hussein.youxeltask.data.model.Match;
import com.hussein.youxeltask.data.model.RemoteDataSource;
import com.hussein.youxeltask.data.remote.data_source.LiveMatchesRemoteDataSource;
import java.util.List;
import javax.inject.Inject;

public class LiveMatchesRepository {

  private LiveMatchesRemoteDataSource remoteDataSource;

  @Inject
  public LiveMatchesRepository(LiveMatchesRemoteDataSource remoteDataSource) {
    this.remoteDataSource = remoteDataSource;
  }

  public RemoteDataSource<List<Match>> getMatches() {
    return remoteDataSource.getMovies();
  }
}