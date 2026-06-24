package com.motwg.task01;

public class Vault {

    private int counter = 50;
    private int clicks = 0;
    private Boolean secure = false;

    public Vault() {}

    public Vault(Boolean secure) {
        this.secure = secure;
    }

    public int getClicks() {
        return clicks;
    }

    public int getCounter() {
        return counter;
    }

    public void performAction(Action a) {
        switch (a.getDirection()) {
            case 'L':
                this.left(a.getNumber());
                break;
            case 'R':
                this.right(a.getNumber());
                break;
            default:
                break;
        }
    }

    public void left(int value) {
        Boolean ghost_zero = value != 0 && this.counter == 0;
        this.counter -= value;
        if (secure) {
            leftOverflow(ghost_zero);
        } else {
            checkZero();
        }
    }

    public void right(long value) {
        this.counter += value;
        if (secure) {
            rightOverflow();
        } else {
            checkZero();
        }
    }

    private void checkZero() {
        this.counter = Math.floorMod(this.counter, 100);
        if (this.counter == 0) {
            this.clicks += 1;
        }
    }

    private void rightOverflow() {
        this.clicks += Math.abs(Math.floorDiv(this.counter, 100));
        this.counter = Math.floorMod(this.counter, 100);
    }

    private void leftOverflow(Boolean from_zero) {
        this.clicks += Math.abs(Math.floorDiv(this.counter, 100));
        this.counter = Math.floorMod(this.counter, 100);
        if (this.counter == 0) {
            this.clicks += 1;
        }

        if (from_zero) {
            this.clicks -= 1;
        }
    }
}
