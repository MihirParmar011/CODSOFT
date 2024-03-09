package com.example.alaramclock;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

//import com.example.alaramclock.Alarm;
//import com.example.alaramclock.R;
//import com.example.alaramclock.Stopwatch;
//import com.example.alaramclock.Timer;
//import com.example.alaramclock.WorldClock;
//import com.example.alaramclock.Alarm;
//import com.example.alaramclock.R;
//import com.example.alaramclock.Stopwatch;
//import com.example.alaramclock.Timer;
//import com.example.alaramclock.WorldClock;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView naview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        naview = findViewById(R.id.naview); // Correct the ID if needed

        naview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_worldclock) {
                    loadfrag(new WorldClock(), false);
                } else if (id == R.id.nav_alarm) {
                    loadfrag(new Alarm(),  false);
                } else if (id == R.id.nav_stopwatch) {
                    loadfrag(new Stopwatch(),false);
                } else {
                    loadfrag(new Timer(), false);
                }
                return true;
            }
        });

        naview.setSelectedItemId(R.id.nav_alarm);
    }

  // else if (id == R.id.nav_stopwatch) {
    //                    loadfrag(new Stopwatch(),false);
    //                }

    private void Loadfrag(Stopwatch stopwatch, boolean b) {}
    private void Loadfrag(WorldClock worldClock, boolean b) {}
    private void Loadfrag(Timer timer,boolean b){}
    private void Loadfrag(Alarm alarm,boolean b){}
    public void loadfrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag) {
            ft.add(R.id.navcbar, fragment);
        } else {
            ft.replace(R.id.navcbar, fragment);
        }
        ft.commit();
    }
}