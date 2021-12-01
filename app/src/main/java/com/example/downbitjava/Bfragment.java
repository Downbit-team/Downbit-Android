package com.example.downbitjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.downbitjava.databinding.ActivityBfragmentBinding;

public class Bfragment extends Fragment {

    ActivityBfragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityBfragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}