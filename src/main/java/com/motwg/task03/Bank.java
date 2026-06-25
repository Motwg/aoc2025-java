package com.motwg.task03;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bank {

    private List<Battery> batteries;

    public Bank(String string) {
        this.batteries = IntStream.range(0, string.length())
            .mapToObj(i -> {
                return new Battery(i, string.charAt(i));
            })
            .sorted()
            .collect(Collectors.toList());
    }

    public List<Battery> getBatteries() {
        return batteries;
    }

    public int joltage() {
        List<Battery> rest = new LinkedList<>(this.batteries);

        Battery first =
            rest.get(0).getPosition() == rest.size() - 1
                ? rest.remove(1)
                : rest.remove(0);
        Battery second = rest
            .stream()
            .dropWhile(b -> {
                return b.getPosition() <= first.getPosition();
            })
            .findFirst()
            .get();
        return Integer.valueOf(
            String.valueOf(first.getValue()) + String.valueOf(second.getValue())
        );
    }

    @Override
    public String toString() {
        return this.batteries.toString();
    }
}
