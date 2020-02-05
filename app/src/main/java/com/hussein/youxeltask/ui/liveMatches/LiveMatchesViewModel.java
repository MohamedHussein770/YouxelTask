package com.hussein.youxeltask.ui.liveMatches;

import com.hussein.youxeltask.app.MyApplication;
import com.hussein.youxeltask.data.model.Match;
import com.hussein.youxeltask.data.model.RemoteDataSource;
import com.hussein.youxeltask.data.repo.LiveMatchesRepository;
import com.hussein.youxeltask.ui.base.BaseViewModel;
import java.util.List;
import javax.inject.Inject;

public class LiveMatchesViewModel extends BaseViewModel {

  @Inject
  LiveMatchesRepository repository;

  private RemoteDataSource<List<Match>> matches;

  public LiveMatchesViewModel() {
    MyApplication.getInstance().getAppComponent().inject(this);

    //DaggerAppComponent.create().inject(this);
    matches = new RemoteDataSource<>();
  }

  void getLiveMatches() {
    matches = repository.getMatches();
  }

  RemoteDataSource<List<Match>> getMoviesData() {
    return matches;
  }

  @Override
  protected void onCleared() {
    super.onCleared();
  }
}
