package com.example.projektzespolowy.ui.recognition4;

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

public class Recognition4Fragment extends Fragment {

    private Recognition4ViewModel recognition4ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recognition4ViewModel =
                new ViewModelProvider(this).get(Recognition4ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recognition4, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        recognition4ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}