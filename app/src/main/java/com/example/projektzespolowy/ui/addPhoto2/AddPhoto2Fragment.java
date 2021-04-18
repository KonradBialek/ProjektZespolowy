package com.example.projektzespolowy.ui.addPhoto2;

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

public class AddPhoto2Fragment extends Fragment {

    private AddPhoto2ViewModel addPhoto2ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addPhoto2ViewModel =
                new ViewModelProvider(this).get(AddPhoto2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_photo2, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        addPhoto2ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}