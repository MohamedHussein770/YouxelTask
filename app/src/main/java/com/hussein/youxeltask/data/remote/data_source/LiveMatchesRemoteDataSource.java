package com.hussein.youxeltask.data.remote.data_source;

import com.hussein.youxeltask.R;
import com.hussein.youxeltask.app.MyApplication;
import com.hussein.youxeltask.data.model.Match;
import com.hussein.youxeltask.data.model.RemoteDataSource;
import com.hussein.youxeltask.data.remote.ApiClient;
import com.hussein.youxeltask.data.remote.response.MatchesResponse;
import com.hussein.youxeltask.utils.Constants;
import com.hussein.youxeltask.utils.NetworkUtils;
import com.uber.autodispose.ScopeProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import static com.uber.autodispose.AutoDispose.autoDisposable;

public class LiveMatchesRemoteDataSource {

  private CompositeDisposable disposable;
  private RemoteDataSource<List<Match>> data;

  public LiveMatchesRemoteDataSource() {
    data = new RemoteDataSource<>();
    disposable = new CompositeDisposable();
  }

  public RemoteDataSource<List<Match>> getMovies() {
    data.setIsLoading();
    disposable
        .add(ApiClient.getInstance().getApiService().getLiveMatches(Constants.KEY, Constants.SECRET)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .as(autoDisposable(ScopeProvider.UNBOUND))
            .subscribeWith(new DisposableSingleObserver<MatchesResponse>() {
              @Override
              public void onSuccess(MatchesResponse matchesResponse) {
                if (!disposable.isDisposed()) {

                  if (matchesResponse != null
                      && matchesResponse.getData() != null) {

                    data.setIsLoaded(matchesResponse.getData().getMatch(),
                        MyApplication.getInstance().getString(R.string.success_remote_load));
                  }

                  dispose();
                }
              }

              @Override
              public void onError(Throwable e) {
                if (!disposable.isDisposed()) {
                  if (!NetworkUtils.isNetworkConnected(MyApplication.getInstance())) {
                    data.setNoInternet();
                  } else {
                    data.setFailed(e.getMessage());
                  }

                  dispose();
                }
              }
            }));

    return data;
  }
}