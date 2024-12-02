package com.example.appchat.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private Context context;

    public MainViewModelFactory(Context context) {
        this.context = context;
    }
}
