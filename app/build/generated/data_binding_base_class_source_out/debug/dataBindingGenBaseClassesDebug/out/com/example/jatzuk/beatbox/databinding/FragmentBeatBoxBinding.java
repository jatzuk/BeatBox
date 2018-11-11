package com.example.jatzuk.beatbox.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public abstract class FragmentBeatBoxBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final SeekBar seekBar;

  @NonNull
  public final TextView textView;

  protected FragmentBeatBoxBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recyclerView, SeekBar seekBar, TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recyclerView = recyclerView;
    this.seekBar = seekBar;
    this.textView = textView;
  }

  @NonNull
  public static FragmentBeatBoxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentBeatBoxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentBeatBoxBinding>inflate(inflater, com.example.jatzuk.beatbox.R.layout.fragment_beat_box, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentBeatBoxBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentBeatBoxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentBeatBoxBinding>inflate(inflater, com.example.jatzuk.beatbox.R.layout.fragment_beat_box, null, false, component);
  }

  public static FragmentBeatBoxBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentBeatBoxBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentBeatBoxBinding)bind(component, view, com.example.jatzuk.beatbox.R.layout.fragment_beat_box);
  }
}
