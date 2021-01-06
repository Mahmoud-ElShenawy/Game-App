package com.m.elshenawy.gameapp.view_model;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;

import com.m.elshenawy.gameapp.view.GameActivity;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class MainViewModel extends BaseObservable {
    public String name;
    Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void click(View view) {
        Intent intent = new Intent(context, GameActivity.class);
        context.startActivity(intent);
    }
}
