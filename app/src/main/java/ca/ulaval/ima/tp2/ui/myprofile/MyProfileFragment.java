package ca.ulaval.ima.tp2.ui.myprofile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ca.ulaval.ima.tp2.Profile;
import ca.ulaval.ima.tp2.R;

public class MyProfileFragment extends Fragment {

    private Profile profile;
    private TextView firstName;
    private TextView lastName;
    private TextView dateBirth;
    private TextView sex;
    private TextView field;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_myprofile, container, false);

        firstName=root.findViewById(R.id.firstNameDisplay);
        lastName=root.findViewById(R.id.NameDisplay);
        dateBirth=root.findViewById(R.id.birthDateDisplay);
        sex=root.findViewById(R.id.sexDisplay);
        field=root.findViewById(R.id.fieldDisplay);

        profile=(Profile)this.getArguments().getParcelable("profile");

        firstName.setText(profile.getFirstName());
        lastName.setText(profile.getName());
        dateBirth.setText(profile.getBirthDate());
        sex.setText(profile.getSex());
        field.setText(profile.getField());


        return root;
    }
}