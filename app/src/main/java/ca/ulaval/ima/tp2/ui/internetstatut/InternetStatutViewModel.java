package ca.ulaval.ima.tp2.ui.internetstatut;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InternetStatutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InternetStatutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}