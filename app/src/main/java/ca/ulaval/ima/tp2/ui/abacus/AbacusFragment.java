package ca.ulaval.ima.tp2.ui.abacus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import ca.ulaval.ima.tp2.R;

public class AbacusFragment extends Fragment {

    private AbacusViewModel abacusViewModel;
    private SeekBar result;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private int value1;
    private int value2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        abacusViewModel =
                ViewModelProviders.of(this).get(AbacusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_abacus, container, false);

        value1=1;
        value2=2;

        result=root.findViewById(R.id.result);
        seekBar1=root.findViewById(R.id.seekbar1);
        seekBar2=root.findViewById(R.id.seekbar2);
        textView=root.findViewById(R.id.textView7);
        textView2=root.findViewById(R.id.textView8);
        textView3=root.findViewById(R.id.textView9);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value1=progress;
                result.setProgress(value1*value2);
                textView.setText("Value : "+progress);
                textView3.setText("Value : "+value1*value2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value2=progress;
                result.setProgress(value1*value2);
                textView2.setText("Value : "+progress);
                textView3.setText("Value : "+value1*value2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });







        return root;
    }
}