package com.hussein.youxeltask.ui.base;

import androidx.lifecycle.ViewModel;
import com.hussein.youxeltask.utils.DisplayLoader;
import com.hussein.youxeltask.utils.SingleLiveEvent;
import com.hussein.youxeltask.utils.display_message.DisplayMessage;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel
    extends ViewModel {

  private CompositeDisposable mCompositeDisposable;
  private DisplayMessage message;
  private DisplayLoader loader;
  private SingleLiveEvent<Void> apiFail;
  private SingleLiveEvent<Void> hideKeyboard;

  public BaseViewModel() {
    mCompositeDisposable = new CompositeDisposable();
    message = new DisplayMessage();
    loader = new DisplayLoader();
    apiFail = new SingleLiveEvent<>();
    hideKeyboard = new SingleLiveEvent<>();
  }

  public CompositeDisposable getDisposable() {
    return mCompositeDisposable;
  }

  public DisplayMessage getMessageObserver() {
    return message;
  }

  public DisplayLoader getLoaderObserver() {
    return loader;
  }

  public SingleLiveEvent<Void> apiFail() {
    return apiFail;
  }

  public SingleLiveEvent<Void> hideKeyboard() {
    return hideKeyboard;
  }

  @Override
  protected void onCleared() {
    dispose();
    super.onCleared();
  }

  private void dispose() {
    if (!mCompositeDisposable.isDisposed()) {
      mCompositeDisposable.clear();
      mCompositeDisposable.dispose();
    }
  }
}