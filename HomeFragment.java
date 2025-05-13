package com.example.mathmania;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Start → Directions
        view.findViewById(R.id.startButton).setOnClickListener(v ->
                ((MainActivity) requireActivity())
                        .loadFragment(new DirectionsFragment(), true)
        );

        // Directions → Level 1
        view.findViewById(R.id.directionsButton).setOnClickListener(v ->
                ((MainActivity) requireActivity())
                        .loadFragment(new Level1Fragment(), true)
        );

        return view;
    }
}
