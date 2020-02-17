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


    private SeekBar result;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private TextView displayValue1;
    private TextView displayValue2;
    private TextView displayResult;
    private int value1;
    private int value2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_abacus, container, false);

        value1=1;
        value2=2;

        result=root.findViewById(R.id.result);
        seekBar1=root.findViewById(R.id.seekbar1);
        seekBar2=root.findViewById(R.id.seekbar2);
        displayValue1=root.findViewById(R.id.seekbar1Value);
        displayValue2=root.findViewById(R.id.seekbar2Value);
        displayResult=root.findViewById(R.id.resultValue);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value1=progress+1;
                result.setProgress(value1*value2);
                displayValue1.setText(value1+"");
                displayResult.setText((value1*value2)+"");
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
                value2=progress+2;
                result.setProgress(value1*value2);
                displayValue2.setText(value2+"");
                displayResult.setText((value1*value2)+"");
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