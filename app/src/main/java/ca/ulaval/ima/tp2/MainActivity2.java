package ca.ulaval.ima.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ca.ulaval.ima.tp2.ui.myprofile.MyProfileFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
