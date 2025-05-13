package com.example.mathmania;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class Level1Fragment extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level1, container, false);
        view.findViewById(R.id.nextButton).setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new Level2Fragment(), true)
        );
        view.findViewById(R.id.backHomeButton).setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new HomeFragment(), false)
        );
        return view;
    }
}
