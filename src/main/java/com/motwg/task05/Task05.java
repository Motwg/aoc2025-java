package com.motwg.task05;

import com.motwg.shared.Task;
import java.util.List;

public class Task05 implements Task {

    @Override
    public long partOne(List<String> input) {
        Database db = new Database(input);
        return db.countFresh();
    }

    @Override
    public long partTwo(List<String> input) {
        Database db = new Database(input);
        return db.countConsideredFresh();
    }
}
