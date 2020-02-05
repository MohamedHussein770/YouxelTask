package com.hussein.youxeltask.ui.main;

import androidx.lifecycle.LiveData;
import com.hussein.youxeltask.ui.base.BaseViewModel;
import com.hussein.youxeltask.utils.SingleLiveEvent;

public class MyViewModel extends BaseViewModel {

  private SingleLiveEvent<Integer> onNavigate;

  public MyViewModel() {

    onNavigate = new SingleLiveEvent<>();
  }

  public void onNavigationIconClicked(int tabId) {

    onNavigate.setValue(tabId);
  }

  LiveData<Integer> onNavigate() {
    return onNavigate;
  }
}
