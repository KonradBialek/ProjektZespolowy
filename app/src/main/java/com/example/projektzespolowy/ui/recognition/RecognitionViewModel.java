package com.example.projektzespolowy.ui.recognition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecognitionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecognitionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}