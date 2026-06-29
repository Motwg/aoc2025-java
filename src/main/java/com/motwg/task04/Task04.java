package com.motwg.task04;

import com.motwg.shared.Task;
import java.util.List;

public class Task04 implements Task {

    @Override
    public long partOne(List<String> input) {
        PaperGrid grid = new PaperGrid(input);
        return grid.accessibleRolls();
    }

    @Override
    public long partTwo(List<String> input) {
        return -1;
    }
}
