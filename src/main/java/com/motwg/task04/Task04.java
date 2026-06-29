package com.motwg.task04;

import com.motwg.shared.Task;
import java.util.List;

public class Task04 implements Task {

    @Override
    public long partOne(List<String> input) {
        PaperGrid grid = new PaperGrid(input);
        return grid.countAccessibleRolls();
    }

    @Override
    public long partTwo(List<String> input) {
        PaperGrid grid = new PaperGrid(input);
        long rolls = 0;
        long removed = 0;
        do {
            removed = grid.removeAccesibbleRolls();
            rolls += removed;
        } while (removed > 0);
        return rolls;
    }
}
