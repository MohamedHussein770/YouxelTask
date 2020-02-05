package com.hussein.youxeltask.ui.main;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import com.hussein.youxeltask.BR;
import com.hussein.youxeltask.R;
import com.hussein.youxeltask.data.enums.Tabs;
import com.hussein.youxeltask.databinding.ActivityMainBinding;
import com.hussein.youxeltask.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MyViewModel> {

  private MyViewModel mainViewModel;

  @Override protected void setUpViewModel() {
    mainViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
    getViewDataBinding().setViewModel(getViewModel());
    initBaseObservables();
  }

  @Override protected void setUpViews() {

  }

  @Override protected void setUpObservables() {
    getViewModel().onNavigate().observe(this, tag -> {

      if (tag == Tabs.LIVE_MATCHES) {

        Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
            .navigate(R.id.matches);
      } else if (tag == Tabs.LIVE_VIDEOS) {

        Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
            .navigate(R.id.videos);
      }
    });
  }

  @Override public int getBindingVariable() {
    return BR.viewModel;
  }

  @Override public int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override public MyViewModel getViewModel() {
    return mainViewModel;
  }
}
