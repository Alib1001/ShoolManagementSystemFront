package com.sis2225.shoolmanagementsystemfront.ui.ShoolList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SchoolListViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SchoolListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}