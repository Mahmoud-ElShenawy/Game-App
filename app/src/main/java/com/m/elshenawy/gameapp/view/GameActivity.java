package com.m.elshenawy.gameapp.view;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.m.elshenawy.gameapp.R;
import com.m.elshenawy.gameapp.databinding.GameActivityBinding;
import com.m.elshenawy.gameapp.model.Player;
import com.m.elshenawy.gameapp.view_model.GameViewModel;

import static com.m.elshenawy.gameapp.utility.DataUtility.isNullOrEmpty;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class GameActivity extends AppCompatActivity {
    private static final String NO_WINNER = "NO WINNER";
    private static final String GAME_START_DIALOG_TAG = "GAME_START_DIALOG_TAG";
    private static final String GAME_END_DIALOG_TAG = "GAME_END_DIALOG_TAG";
    GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        promptForPlayer();
    }

    public void promptForPlayer() {
        GameStartDialog gameStartDialog = GameStartDialog.newInstance(this);
        gameStartDialog.setCancelable(false);
        gameStartDialog.show(getSupportFragmentManager(), GAME_START_DIALOG_TAG);

    }


    public void onPlayerSet(String firstPlayer, String secondPlayer) {
        initDataBinding(firstPlayer, secondPlayer);
    }

    private void initDataBinding(String firstPlayer, String secondPlayer) {
        GameActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.game_activity);
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.init(firstPlayer, secondPlayer);
        binding.setGameViewModel(gameViewModel);
        setUpOnGameEndListener();
    }

    private void setUpOnGameEndListener() {
        gameViewModel.getWinner().observe(this, this::onGameWinnerChanged);
    }

    private void onGameWinnerChanged(Player winner) {
        String winnerName = winner == null || isNullOrEmpty(winner.getName()) ? NO_WINNER : winner.getName();
        GameEndDialog gameEndDialog = GameEndDialog.newInstance(this, winnerName);
        gameEndDialog.setCancelable(false);
        gameEndDialog.show(getSupportFragmentManager(), GAME_END_DIALOG_TAG);
    }
}
