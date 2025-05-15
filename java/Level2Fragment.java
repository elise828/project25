package com.example.teamproject25;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class Level2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_level2, container, false);

        Button nextButton = view.findViewById(R.id.nextButton);
        Button homeButton = view.findViewById(R.id.homeButton);

        nextButton.setOnClickListener(v -> {
            // Navigate back to DirectionsFragment
            ((MainActivity) requireActivity()).loadFragment(new Level3Fragment(), false);
        });

        homeButton.setOnClickListener(v -> {
            // Navigate to HomeFragment
            ((MainActivity) requireActivity()).loadFragment(new HomeFragment(), false);
        });

        return view;
    }
}

