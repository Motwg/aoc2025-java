package com.motwg.task03;

import java.util.Comparator;

public class BatteryPosComparator implements Comparator<Battery> {

    @Override
    public int compare(Battery first, Battery second) {
        return first.getPosition() - second.getPosition();
    }
}
