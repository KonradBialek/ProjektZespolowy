package com.example.projektzespolowy.ui.userBrowser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserBrowserViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserBrowserViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}