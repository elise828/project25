package com.example.mathmania;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class DirectionsFragment extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directions, container, false);
        view.findViewById(R.id.backHomeButton).setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new HomeFragment(), false)
        );
        return view;
    }
}
