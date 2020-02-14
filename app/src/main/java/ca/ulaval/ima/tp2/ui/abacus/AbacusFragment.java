package ca.ulaval.ima.tp2.ui.abacus;

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

public class AbacusFragment extends Fragment {

    private AbacusViewModel abacusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        abacusViewModel =
                ViewModelProviders.of(this).get(AbacusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_abacus, container, false);
        final TextView textView = root.findViewById(R.id.text_abacus);
        abacusViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}