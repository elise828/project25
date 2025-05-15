package com.example.teamproject25;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class DirectionsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directions, container, false);

        // Level 1 Button - load Level1Fragment
        Button level1Btn = view.findViewById(R.id.level1Button);
        level1Btn.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new Level1Fragment(), true));

        // Level 2 Button - load Level2Fragment
        Button level2Btn = view.findViewById(R.id.level2Button);
        level2Btn.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new Level2Fragment(), true));

        // Level 3 Button - load Level3Fragment
        Button level3Btn = view.findViewById(R.id.level3Button);
        level3Btn.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new Level3Fragment(), true));

        return view;
    }
}
