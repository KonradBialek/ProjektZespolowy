package com.example.projektzespolowy.ui.recognition4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Recognition4ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Recognition4ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}