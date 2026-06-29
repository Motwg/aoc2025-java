package com.motwg.task04;

import com.motwg.shared.Grid;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PaperGrid extends Grid<Character> {

    public PaperGrid(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                this.set(j, i, line.charAt(j));
            }
        }
    }

    public long removeAccesibbleRolls() {
        long i = 0;
        for (Map.Entry<Point, Character> roll : accessibleRolls()) {
            remove(roll.getKey());
            i += 1;
        }
        return i;
    }

    public int countAccessibleRolls() {
        return accessibleRolls().size();
    }

    private List<Map.Entry<Point, Character>> accessibleRolls() {
        List<Map.Entry<Point, Character>> rolls = new LinkedList<>();
        for (Map.Entry<Point, Character> roll : this) {
            if (
                isAccessible(
                    (int) roll.getKey().getX(),
                    (int) roll.getKey().getY()
                )
            ) {
                rolls.add(roll);
            }
        }
        return rolls;
    }

    private boolean isAccessible(int i, int j) {
        long adjacents = countAdjacent(i, j, '@');
        if (adjacents < 4) {
            return true;
        } else {
            return false;
        }
    }

    private long countAdjacent(int i, int j, char value) {
        long counter = 9;
        if (get(i, j) == value) {
            counter =
                IntStream.of(-1, 0, 1)
                    .mapToLong(a ->
                        IntStream.of(-1, 0, 1)
                            .map(b -> getOrDefault(i + a, j + b, ' '))
                            .filter(ch -> ch == value)
                            .count()
                    )
                    .sum() - 1;
        }
        return counter;
    }
}
