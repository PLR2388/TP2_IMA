package ca.ulaval.ima.tp2.ui.form;

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

public class FormFragment extends Fragment {

    private FormViewModel formViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        formViewModel =
                ViewModelProviders.of(this).get(FormViewModel.class);
        View root = inflater.inflate(R.layout.fragment_form, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        formViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}