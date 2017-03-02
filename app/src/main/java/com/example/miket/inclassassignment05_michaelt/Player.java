package com.example.miket.inclassassignment05_michaelt;

import java.io.Serializable;


public class Player implements Serializable {

    private String name;
    private int playerNumber;
    private String note;


    public Player(String name, int playerNumber, String note) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Player Name: " + name + "\nPlayer Number: " + playerNumber + "\nPlayer Note: " + note;
    }
}
