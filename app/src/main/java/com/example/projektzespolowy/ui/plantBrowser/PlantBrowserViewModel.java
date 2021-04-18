package com.example.projektzespolowy.ui.plantBrowser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantBrowserViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlantBrowserViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}