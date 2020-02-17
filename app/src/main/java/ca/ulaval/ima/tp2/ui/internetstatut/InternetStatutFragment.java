package ca.ulaval.ima.tp2.ui.internetstatut;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import ca.ulaval.ima.tp2.R;

public class InternetStatutFragment extends Fragment {

    private TextView internetStatutLabel;
    private ImageView indicator;
    private Button button;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_internetstatut, container, false);

        internetStatutLabel=root.findViewById(R.id.InternetLabel);
        indicator=root.findViewById(R.id.IndicatorImage);
        button=root.findViewById(R.id.buttonInternet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm =
                        (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();
                if(isConnected){
                    indicator.setImageResource(R.drawable.greencircle);
                    if(cm.isActiveNetworkMetered()){
                        internetStatutLabel.setText("3G/LTE");

                    }
                    else{
                        internetStatutLabel.setText("WIFI");
                    }
                }
                else{
                    indicator.setImageResource(R.drawable.redcircle);
                    internetStatutLabel.setText("Aucune connexion");
                }
            }
        });

        return root;
    }


}