package com.hussein.youxeltask.ui.liveVideos;

import androidx.lifecycle.ViewModelProviders;
import com.hussein.youxeltask.BR;
import com.hussein.youxeltask.R;
import com.hussein.youxeltask.databinding.FragmentLiveVideosBinding;
import com.hussein.youxeltask.ui.base.BaseFragment;

public class LiveVideosFragment
    extends BaseFragment<FragmentLiveVideosBinding, LiveVideosViewModel> {

  private LiveVideosViewModel liveVideosViewModel;

  public LiveVideosFragment() {
    // Required empty public constructor
  }

  @Override protected void setUpViewModel() {
    liveVideosViewModel = ViewModelProviders.of(this).get(LiveVideosViewModel.class);
    getViewDataBinding().setViewModel(getViewModel());
    initBaseObservables();
  }

  @Override protected void setUpViews() {

  }

  @Override protected void setUpObservables() {

  }

  @Override public int getBindingVariable() {
    return BR.viewModel;
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_live_videos;
  }

  @Override public boolean hasOptionMenu() {
    return false;
  }

  @Override public LiveVideosViewModel getViewModel() {
    return liveVideosViewModel;
  }
}
