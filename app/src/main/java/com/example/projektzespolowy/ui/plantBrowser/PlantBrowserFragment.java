package com.example.projektzespolowy.ui.plantBrowser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projektzespolowy.R;

public class PlantBrowserFragment extends Fragment {

    private PlantBrowserViewModel plantBrowserViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        plantBrowserViewModel =
                new ViewModelProvider(this).get(PlantBrowserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_plant_browser, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        plantBrowserViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}