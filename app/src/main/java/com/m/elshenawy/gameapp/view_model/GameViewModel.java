package com.m.elshenawy.gameapp.view_model;

import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.m.elshenawy.gameapp.model.Cell;
import com.m.elshenawy.gameapp.model.Game;
import com.m.elshenawy.gameapp.model.Player;

import static com.m.elshenawy.gameapp.utility.DataUtility.stringFromNumbers;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class GameViewModel extends ViewModel {
    public ObservableArrayMap<String, String> cells;
    private Game game;

    public void init(String firstPlayer, String secondPlayer) {
        game = new Game(firstPlayer, secondPlayer);
        cells = new ObservableArrayMap<>();
    }

    public void onClickedCellAt(int row, int column) {
        if (game.getCells()[row][column] == null) {
            game.getCells()[row][column] = new Cell(game.getCurrentPlayer());
            cells.put(stringFromNumbers(row, column), game.getCurrentPlayer().getValue());
            if (game.hasGameEnded())
                game.reset();
            else
                game.switchPlayer();
        }
    }

    public LiveData<Player> getWinner() {
        return game.winner;
    }
}
