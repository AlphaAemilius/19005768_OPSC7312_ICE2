package com.vc19005768.sqllitetodo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vc19005768.sqllitetodo.Fragments.AddChoreFragment;
import com.vc19005768.sqllitetodo.Fragments.ChoreModelFragment;
import com.vc19005768.sqllitetodo.Fragments.CompleteFragment;
import com.vc19005768.sqllitetodo.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav); //assigns logical
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont, new HomeFragment()).commit(); //selects home on startup
        bottomNav.setSelectedItemId( R.id.nav_Home); //sets the middle item as selected on startup (home)
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =   //for selecting a nav bar item
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_Add:
                            selectedFragment  = new AddChoreFragment();
                            break;
                        case R.id.nav_Home:
                            selectedFragment  = new ChoreModelFragment();
                            break;
                        case R.id.nav_Complete:
                            selectedFragment  = new CompleteFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,selectedFragment).commit(); //launches fragment
                    return true;
                }
            };


}