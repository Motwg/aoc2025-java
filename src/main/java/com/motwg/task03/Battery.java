package com.motwg.task03;

public class Battery implements Comparable<Battery> {

    private int position;
    private int value;

    public Battery(int position, char value) {
        this.position = position;
        this.value = value - 48;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(position) + ": " + String.valueOf(value);
    }

    @Override
    public int compareTo(Battery other) {
        if (this.value != other.getValue()) {
            return other.getValue() - this.value;
        } else {
            return this.position - other.getPosition();
        }
    }
}
