package com.example.projektzespolowy.ui.recognition2;

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

public class Recognition2Fragment extends Fragment {

    private Recognition2ViewModel recognition2ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recognition2ViewModel =
                new ViewModelProvider(this).get(Recognition2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recognition2, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        recognition2ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}