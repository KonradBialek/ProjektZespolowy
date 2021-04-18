package com.example.projektzespolowy.ui.addPhoto2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddPhoto2ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddPhoto2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}