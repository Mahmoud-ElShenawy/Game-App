package com.m.elshenawy.gameapp.model;

import com.m.elshenawy.gameapp.utility.DataUtility;

// Created By Mahmoud El Shenawy (Email : Mr.Mahmoud.El.Shenawy@Gmail.com)

public class Cell {
    private Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null || DataUtility.isNullOrEmpty(player.getValue());
    }
}
