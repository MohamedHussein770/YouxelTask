package com.hussein.youxeltask.ui.liveMatches;

import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.hussein.youxeltask.R;
import com.hussein.youxeltask.data.enums.NetworkState;
import com.hussein.youxeltask.data.model.Match;
import com.hussein.youxeltask.databinding.FragmentLiveMatchesBinding;
import com.hussein.youxeltask.ui.base.BaseFragment;
import com.hussein.youxeltask.utils.CommonUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveMatchesFragment
    extends BaseFragment<FragmentLiveMatchesBinding, LiveMatchesViewModel> implements
    MatchesAdapter.MatchesListener {

  private MatchesAdapter matchesAdapter;
  private List<Match> LiveMatches = new ArrayList<>();

  private LiveMatchesViewModel liveMatchesViewModel;

  public LiveMatchesFragment() {
    // Required empty public constructor
  }

  @Override protected void setUpViewModel() {
    liveMatchesViewModel = ViewModelProviders.of(this).get(LiveMatchesViewModel.class);
    getViewDataBinding().setViewModel(getViewModel());
    initBaseObservables();
  }

  @Override
  public void onStart() {
    super.onStart();

    matchesAdapter.registerListener(this);
  }

  @Override
  public void onStop() {
    matchesAdapter.unRegisterListener();

    super.onStop();
  }

  @Override protected void setUpViews() {
    initMoviesRecyclerView();

    getData();
  }

  private void getData() {
    showProgress();
    getViewModel().getLiveMatches();
  }

  @Override protected void setUpObservables() {
    getViewModel().getMoviesData().getNetworkState().observe(this, state -> {
      if (state != null) {
        if (state == NetworkState.LOADED) {
          if (!getViewModel().getMoviesData().getData().isEmpty()) {
            matchesAdapter.replaceItems(getViewModel().getMoviesData().getData());
            showData();
          } else {
            showNoData();
          }
        } else if (state == NetworkState.FAILED) {
          showNoData();
        } else if (state == NetworkState.NO_INTERNET) {
          showNoInternet();
        }
      }
    });
  }

  @Override public int getBindingVariable() {
    return com.hussein.youxeltask.BR.viewModel;
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_live_matches;
  }

  @Override public boolean hasOptionMenu() {
    return false;
  }

  @Override public LiveMatchesViewModel getViewModel() {
    return liveMatchesViewModel;
  }

  private void initMoviesRecyclerView() {
    CommonUtils.configRecyclerView(getViewDataBinding().includedList.recyclerView, true);
    matchesAdapter = new MatchesAdapter(LiveMatches);
    getViewDataBinding().includedList.recyclerView.setAdapter(matchesAdapter);
    getViewDataBinding().includedList.reloadBtn.setOnClickListener(v -> getData());
  }

  private void showData() {
    getViewDataBinding().includedList.recyclerView.setVisibility(View.VISIBLE);
    getViewDataBinding().includedList.container.setVisibility(View.GONE);
    getViewDataBinding().includedList.progressBar.setVisibility(View.GONE);
  }

  private void showNoData() {
    getViewDataBinding().includedList.recyclerView.setVisibility(View.GONE);
    getViewDataBinding().includedList.progressBar.setVisibility(View.GONE);
    getViewDataBinding().includedList.emptyViewContainer.setVisibility(View.VISIBLE);
    getViewDataBinding().includedList.internetErrorViewContainer.setVisibility(View.GONE);
    getViewDataBinding().includedList.reloadBtn.setVisibility(View.GONE);
    getViewDataBinding().includedList.container.setVisibility(View.VISIBLE);
  }

  private void showProgress() {
    getViewDataBinding().includedList.recyclerView.setVisibility(View.GONE);
    getViewDataBinding().includedList.progressBar.setVisibility(View.VISIBLE);
    getViewDataBinding().includedList.emptyViewContainer.setVisibility(View.GONE);
    getViewDataBinding().includedList.internetErrorViewContainer.setVisibility(View.GONE);
    getViewDataBinding().includedList.reloadBtn.setVisibility(View.GONE);
    getViewDataBinding().includedList.container.setVisibility(View.VISIBLE);
  }

  private void showNoInternet() {
    getViewDataBinding().includedList.recyclerView.setVisibility(View.GONE);
    getViewDataBinding().includedList.progressBar.setVisibility(View.GONE);
    getViewDataBinding().includedList.emptyViewContainer.setVisibility(View.GONE);
    getViewDataBinding().includedList.internetErrorViewContainer.setVisibility(View.VISIBLE);
    getViewDataBinding().includedList.reloadBtn.setVisibility(View.VISIBLE);
    getViewDataBinding().includedList.container.setVisibility(View.VISIBLE);
  }

  @Override public void onMatchClicked(Match match) {

  }
}
