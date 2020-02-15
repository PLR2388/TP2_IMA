package ca.ulaval.ima.tp2.ui.internetstatut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import ca.ulaval.ima.tp2.R;

public class InternetStatutFragment extends Fragment {

    private InternetStatutViewModel internetStatutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        internetStatutViewModel =
                ViewModelProviders.of(this).get(InternetStatutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_internetstatut, container, false);
        
        return root;
    }
}