package ca.ulaval.ima.tp2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import ca.ulaval.ima.tp2.ui.abacus.AbacusFragment;
import ca.ulaval.ima.tp2.ui.about.AboutFragment;
import ca.ulaval.ima.tp2.ui.form.FormFragment;
import ca.ulaval.ima.tp2.ui.internetstatut.InternetStatutFragment;
import ca.ulaval.ima.tp2.ui.myprofile.MyProfileFragment;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_about,
                R.id.nav_internetstatut,  R.id.nav_abacus,
                 R.id.nav_form, R.id.nav_myprofile)
                .setDrawerLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        if (savedInstanceState == null) {
            navigationView.getMenu().performIdentifierAction(R.id.nav_myprofile, 0);

        }

        //Just to show a back arrow
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getLabel().toString().equals("Formulaire")){
                    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
                }
            }
        });


    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_internetstatut:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new InternetStatutFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new AboutFragment()).commit();
                break;
            case R.id.nav_abacus:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new AbacusFragment()).commit();
                break;
            case R.id.nav_form:
                //To have a back arrow
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new FormFragment()).commit();
                break;
            case R.id.nav_myprofile:
                MyProfileFragment fragment=new MyProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,fragment).commit();
                break;
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        if(navController.getCurrentDestination().getLabel().toString().equals("Formulaire")){ //React to press when form opens
            onBackPressed();
            return true;
        }
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



}
