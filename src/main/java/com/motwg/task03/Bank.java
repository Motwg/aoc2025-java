package com.motwg.task03;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bank {

    private List<Battery> offBatteries;
    private List<Battery> onBatteries;

    public Bank(String string) {
        this.onBatteries = new LinkedList<>();
        this.offBatteries = IntStream.range(0, string.length())
            .mapToObj(i -> {
                return new Battery(i, string.charAt(i));
            })
            .sorted()
            .collect(Collectors.toList());
    }

    public List<Battery> getOnBatteries() {
        return onBatteries;
    }

    public List<Battery> getOffBatteries() {
        return offBatteries;
    }

    public Battery chooseBest(int fromPos, int toPos) {
        return offBatteries
            .stream()
            .dropWhile(b -> {
                return fromPos > b.getPosition() || b.getPosition() > toPos;
            })
            .findFirst()
            .get();
    }

    public long turnOn(int size) {
        IntStream.range(0, size).forEachOrdered(current -> {
            int fromPos = onBatteries.isEmpty()
                ? -1
                : onBatteries.get(onBatteries.size() - 1).getPosition();
            Battery winner = chooseBest(
                fromPos,
                offBatteries.size() + onBatteries.size() - size + current
            );
            offBatteries.remove(winner);
            onBatteries.add(winner);
        });
        return currentJoltage();
    }

    public long currentJoltage() {
        return Long.valueOf(
            onBatteries
                .stream()
                .sorted(new BatteryPosComparator())
                .map(Battery::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining())
        );
    }

    @Override
    public String toString() {
        return (
            "Off:\t" +
            this.offBatteries.toString() +
            "\nOn :\t" +
            this.onBatteries.toString()
        );
    }
}
