package com.example.jatzuk.beatbox.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jatzuk.beatbox.SoundViewModel;

public abstract class ListItemSoundBinding extends ViewDataBinding {
  @Bindable
  protected SoundViewModel mViewModel;

  protected ListItemSoundBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setViewModel(@Nullable SoundViewModel viewModel);

  @Nullable
  public SoundViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ListItemSoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ListItemSoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ListItemSoundBinding>inflate(inflater, com.example.jatzuk.beatbox.R.layout.list_item_sound, root, attachToRoot, component);
  }

  @NonNull
  public static ListItemSoundBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ListItemSoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ListItemSoundBinding>inflate(inflater, com.example.jatzuk.beatbox.R.layout.list_item_sound, null, false, component);
  }

  public static ListItemSoundBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ListItemSoundBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ListItemSoundBinding)bind(component, view, com.example.jatzuk.beatbox.R.layout.list_item_sound);
  }
}
