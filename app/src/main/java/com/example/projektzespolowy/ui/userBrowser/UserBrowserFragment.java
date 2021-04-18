package com.example.projektzespolowy.ui.userBrowser;

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
import com.example.projektzespolowy.ui.userBrowser.UserBrowserViewModel;

public class UserBrowserFragment extends Fragment {

    private UserBrowserViewModel userBrowserViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userBrowserViewModel =
                new ViewModelProvider(this).get(UserBrowserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_browser, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        userBrowserViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}