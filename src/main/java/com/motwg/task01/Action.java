package com.motwg.task01;

public class Action {

    private char direction;
    private int number;

    public char getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }

    public Action(String line) {
        this.direction = line.charAt(0);
        this.number = Integer.parseInt(line.substring(1));
    }

    public String toString() {
        return this.direction + Integer.toString(this.getNumber());
    }
}
