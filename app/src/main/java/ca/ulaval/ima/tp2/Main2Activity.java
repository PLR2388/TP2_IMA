package ca.ulaval.ima.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;

import com.google.android.material.navigation.NavigationView;

import ca.ulaval.ima.tp2.ui.myprofile.MyProfileFragment;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    public void onBackPressed() {
        Profile p= (Profile) getIntent().getExtras().get("profile");
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("profile",p);
        startActivity(intent);
    }
}
