package com.example.teamproject25;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class Level3Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_level3, container, false);

        Button DirectionsButton = view.findViewById(R.id.directionsButton);
        Button homeButton = view.findViewById(R.id.homeButton);

        DirectionsButton.setOnClickListener(v -> {
            // Navigate back to DirectionsFragment
            ((MainActivity) requireActivity()).loadFragment(new DirectionsFragment(), false);
        });

        homeButton.setOnClickListener(v -> {
            // Navigate to HomeFragment
            ((MainActivity) requireActivity()).loadFragment(new HomeFragment(), false);
        });

        return view;
    }
}
