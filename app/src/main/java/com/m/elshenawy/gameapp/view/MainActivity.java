package com.m.elshenawy.gameapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.m.elshenawy.gameapp.R;
import com.m.elshenawy.gameapp.databinding.ActivityMainBinding;
import com.m.elshenawy.gameapp.view_model.MainViewModel;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(MainActivity.this);
        binding.setMainViewModel(mainViewModel);
    }
}
