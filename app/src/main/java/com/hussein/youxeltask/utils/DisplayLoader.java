package com.hussein.youxeltask.utils;

import androidx.lifecycle.LifecycleOwner;

public class DisplayLoader
    extends SingleLiveEvent<Boolean> {

  public void observe(LifecycleOwner owner, final LoaderObserver observer) {
    super.observe(owner, t -> {
      if (t == null) {
        return;
      }
      observer.showHideLoader(t);
    });
  }

  public interface LoaderObserver {
    /**
     * Called when need to show/hide loader dialog
     *
     * @param showLoader boolean to specify show/hide loader
     */
    void showHideLoader(Boolean showLoader);
  }
}