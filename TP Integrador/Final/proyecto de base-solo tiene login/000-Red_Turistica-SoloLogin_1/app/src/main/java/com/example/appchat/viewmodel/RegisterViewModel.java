package com.example.appchat.viewmodel;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.appchat.model.User;
import com.parse.ParseUser;

public class RegisterViewModel extends ViewModel {
    private final MutableLiveData<String> registerResult = new MutableLiveData<>();

    public LiveData<String> getRegisterResult() {
        return registerResult;
    }
}