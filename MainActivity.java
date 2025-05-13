package com.example.mathmania;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Load HomeFragment on launch
        loadFragment(new HomeFragment(), false);
    }

    /** Replaces the container with the given fragment. */
    public void loadFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction tx = fm.beginTransaction()
                .replace(R.id.fragment_container, fragment);
        if (addToBackStack) tx.addToBackStack(null);
        tx.commit();
    }
}
