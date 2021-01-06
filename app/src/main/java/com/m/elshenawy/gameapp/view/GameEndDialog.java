package com.m.elshenawy.gameapp.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.m.elshenawy.gameapp.R;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class GameEndDialog extends DialogFragment {
    private View view;
    private GameActivity gameActivity;
    private String winnerName;

    public static GameEndDialog newInstance(GameActivity gameActivity, String winnerName) {
        GameEndDialog gameEndDialog = new GameEndDialog();
        gameEndDialog.gameActivity = gameActivity;
        gameEndDialog.winnerName = winnerName;
        return gameEndDialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        initView();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .setCancelable(false)
                .setPositiveButton(R.string.done, (((dialog, which) -> onNewGame())))
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;

    }

    private void initView() {
        view = LayoutInflater.from(getContext())
                .inflate(R.layout.game_end_dialog, null, false);
        ((TextView) view.findViewById(R.id.tv_winner)).setText(winnerName);
    }

    private void onNewGame() {
        dismiss();
        gameActivity.promptForPlayer();
    }

}
