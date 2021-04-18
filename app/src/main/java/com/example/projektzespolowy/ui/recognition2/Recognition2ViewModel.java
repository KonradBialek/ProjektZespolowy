package com.example.projektzespolowy.ui.recognition2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Recognition2ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Recognition2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}