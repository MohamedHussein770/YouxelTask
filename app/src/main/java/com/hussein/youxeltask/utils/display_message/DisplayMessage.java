package com.hussein.youxeltask.utils.display_message;

import androidx.lifecycle.LifecycleOwner;
import com.hussein.youxeltask.utils.SingleLiveEvent;

public class DisplayMessage
    extends SingleLiveEvent<Message> {

  public void observe(LifecycleOwner owner, final MessageObserver observer) {
    super.observe(owner, t -> {
      if (t == null) {
        return;
      }
      observer.onNewMessage(t);
    });
  }

  public interface MessageObserver {
    /**
     * Called when there is a new message to be shown.
     *
     * @param message The new message
     */
    void onNewMessage(Message message);
  }
}