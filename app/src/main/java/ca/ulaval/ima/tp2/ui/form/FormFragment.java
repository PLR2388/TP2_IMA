package ca.ulaval.ima.tp2.ui.form;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import java.util.Calendar;

import ca.ulaval.ima.tp2.MainActivity;
import ca.ulaval.ima.tp2.R;

public class FormFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private FormViewModel formViewModel;
    private EditText dateofbirth;
    private FragmentManager fragmentManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        formViewModel =
                ViewModelProviders.of(this).get(FormViewModel.class);
        View root = inflater.inflate(R.layout.fragment_form, container, false);
        fragmentManager=getActivity().getSupportFragmentManager();
        dateofbirth=root.findViewById(R.id.birthDateEditText);

        dateofbirth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                            dateofbirth.setText(selectedyear+"-"+selectedmonth+"-"+selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Selectionnes ta date de naissance : ");
                mDatePicker.show();  }
        });


        return root;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}