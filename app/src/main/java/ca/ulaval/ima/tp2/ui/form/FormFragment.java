package ca.ulaval.ima.tp2.ui.form;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import ca.ulaval.ima.tp2.MainActivity2;
import ca.ulaval.ima.tp2.Profile;
import ca.ulaval.ima.tp2.R;

public class FormFragment extends Fragment {

    private EditText dateofbirth;
    private EditText firstName;
    private EditText lastName;
    private RadioGroup sex;
    private Spinner spinner;
    private Button submitButton;
    private ActionBar actionBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_form, container, false);
        dateofbirth = root.findViewById(R.id.birthDateEditText);
        firstName = root.findViewById(R.id.firstNameEditText);
        lastName = root.findViewById(R.id.NameEditText);
        sex = root.findViewById(R.id.radioGroup);
        spinner = root.findViewById(R.id.spinner);
        submitButton=root.findViewById(R.id.submitButton);
        actionBar=getActivity().getActionBar();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.fields_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        dateofbirth.setText("1997-02-18");
        sex.check(R.id.maleButton);
        firstName.setText("Paul-Louis");
        lastName.setText("Renard");



        firstName.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        lastName.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        dateofbirth.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        dateofbirth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        CharSequence month = "" + (selectedmonth + 1);
                        CharSequence day = "" + selectedday;
                        if (selectedmonth < 10) {
                            month = "0" + month;
                        }
                        if (selectedday < 10) {
                            day = "0" + day;
                        }
                        dateofbirth.setText(selectedyear + "-" + month + "-" + day);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Selectionnes ta date de naissance : ");
                mDatePicker.show();
            }
        });

        dateofbirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        CharSequence month = "" + (selectedmonth + 1);
                        CharSequence day = "" + selectedday;
                        if (selectedmonth < 10) {
                            month = "0" + month;
                        }
                        if (selectedday < 10) {
                            day = "0" + day;
                        }
                        dateofbirth.setText(selectedyear + "-" + month + "-" + day);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Selectionnes ta date de naissance : ");
                mDatePicker.show();
            }
        });

        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first=firstName.getText().toString();
                String last=lastName.getText().toString();
                String date=dateofbirth.getText().toString();
                String genre;
                if(sex.getCheckedRadioButtonId()==R.id.maleButton){
                    genre="Masculin";
                }
                else{
                    genre="Féminin";
                }
                String program=spinner.getSelectedItem().toString();

                Profile profile=new Profile(first,last,date,genre,program);

                Intent intent=new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("profile",profile);
                startActivity(intent);

            }
        });


        return root;
    }


}



