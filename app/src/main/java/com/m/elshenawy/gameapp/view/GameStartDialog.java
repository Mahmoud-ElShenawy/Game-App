package com.m.elshenawy.gameapp.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.m.elshenawy.gameapp.R;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class GameStartDialog extends DialogFragment {
    GameActivity gameActivity;
    private String firstPlayer;
    private String secondPlayer;
    private View view;
    private TextInputLayout player1Layout;
    private TextInputLayout player2Layout;
    private TextInputEditText player1EditText;
    private TextInputEditText player2EditText;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        initView();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .setTitle(R.string.new_game)
                .setCancelable(false)
                .setPositiveButton(R.string.done, null)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.setOnShowListener(dialog -> {
            onDialogShow(alertDialog);
        });
        return alertDialog;


    }

    private void onDialogShow(AlertDialog alertDialog) {
        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(v -> {
            onDoneClicked();
        });
    }

    private void onDoneClicked() {
        if (isValidName(player1Layout, firstPlayer) & isValidName(player2Layout, secondPlayer)) {
            gameActivity.onPlayerSet(firstPlayer, secondPlayer);
            dismiss();
        }
    }

    private boolean isValidName(TextInputLayout layout, String namePlayer) {
        if (TextUtils.isEmpty(namePlayer)) {
            layout.setErrorEnabled(true);
            layout.setError(getString(R.string.empty_name_error));
            return false;
        }
        if (firstPlayer != null && secondPlayer != null && firstPlayer.equalsIgnoreCase(secondPlayer)) {
            layout.setErrorEnabled(true);
            layout.setError(getString(R.string.same_name_error));
            return false;
        }
        layout.setErrorEnabled(false);
        layout.setError("");
        return true;
    }

    private void initView() {
        view = LayoutInflater.from(getContext())
                .inflate(R.layout.game_start_dialog, null, false);
        player1Layout = view.findViewById(R.id.textInputLayoutPlayer1);
        player2Layout = view.findViewById(R.id.textInputLayoutPlayer2);
        player1EditText = view.findViewById(R.id.textInputPlayer1);
        player2EditText = view.findViewById(R.id.textInputPlayer2);
        addTextWatcher();

    }

    public static GameStartDialog newInstance(GameActivity gameActivity) {
        GameStartDialog gameStartDialog = new GameStartDialog();
        gameStartDialog.gameActivity = gameActivity;
        return gameStartDialog;
    }

    private void addTextWatcher() {
        player1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                firstPlayer = s.toString();
            }
        });
        player2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                secondPlayer = s.toString();
            }
        });
    }
}
