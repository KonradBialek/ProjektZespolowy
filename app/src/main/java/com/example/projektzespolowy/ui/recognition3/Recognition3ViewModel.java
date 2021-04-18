package com.example.projektzespolowy.ui.recognition3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Recognition3ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Recognition3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}