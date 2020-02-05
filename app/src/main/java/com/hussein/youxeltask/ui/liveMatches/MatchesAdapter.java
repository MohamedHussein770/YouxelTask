package com.hussein.youxeltask.ui.liveMatches;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.hussein.youxeltask.R;
import com.hussein.youxeltask.app.MyApplication;
import com.hussein.youxeltask.data.model.Match;
import com.hussein.youxeltask.databinding.ItemMatchBinding;
import com.hussein.youxeltask.ui.base.BaseAdapter;
import com.hussein.youxeltask.ui.base.BaseViewHolder;
import java.util.List;

public class MatchesAdapter extends BaseAdapter<Match> {

  private List<Match> items;
  private MatchesListener listener;

  private int lastPosition = -1;

  MatchesAdapter(List<Match> items) {
    super(items);
    this.items = items;
  }

  @Override
  public RecyclerView.ViewHolder setViewHolder(ViewGroup parent) {
    ItemMatchBinding binding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.getContext()),
        R.layout.item_match,
        parent,
        false);
    return new MatchesAdapter.ViewHolder(binding);
  }

  @Override
  public void onBindData(RecyclerView.ViewHolder holder, int position) {
    ViewHolder myHolder = (ViewHolder) holder;
    myHolder.onBind(position);

    // add anim to items
    setAnimation(holder.itemView, position);
  }

  // start animation
  private void setAnimation(View viewToAnimate, int position) {
    // If the bound view wasn't previously displayed on screen, it's animated
    if (position > lastPosition) {
      Animation animation = AnimationUtils.loadAnimation(MyApplication.getInstance(),
          (position > lastPosition) ? R.anim.translate : R.anim.slide_up);
      viewToAnimate.startAnimation(animation);
      lastPosition = position;
    }
  }

  // To solve the problem of fast scroll
  @Override
  public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
    super.onViewDetachedFromWindow(holder);
    ViewHolder myHolder = (ViewHolder) holder;
    myHolder.clearAnimation();
    myHolder.unbind();
  }

  public interface MatchesListener {
    void onMatchClicked(Match match);
  }

  void registerListener(MatchesListener listener) {
    this.listener = listener;
  }

  void unRegisterListener() {
    listener = null;
  }

  class ViewHolder
      extends BaseViewHolder {

    private final ItemMatchBinding itemBinding;

    ViewHolder(ItemMatchBinding itemBinding) {
      super(itemBinding.getRoot());
      this.itemBinding = itemBinding;
    }

    @Override
    public void onBind(int position) {
      itemBinding.setItem(items.get(position));
      //itemBinding.setListener(listener);
      //
      //itemBinding.rateAmount.setRating(items.get(position).getVote_average());
    }

    @Override
    public void unbind() {// Don't forget to unbind
      if (itemBinding != null) {
        itemBinding.unbind();
      }
    }

    @Override
    public void clearAnimation() {
      itemView.clearAnimation();
    }
  }
}
