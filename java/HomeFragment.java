package com.example.teamproject25;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate only once
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Start button logic: Launch MainGame activity
        Button startButton = view.findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MainGame.class));
        });

        // Directions button logic: Load DirectionsFragment
        Button directionsButton = view.findViewById(R.id.directionsButton);
        directionsButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).loadFragment(new DirectionsFragment(), true);
        });

        return view;
    }
}
