package com.motwg.task03;

import com.motwg.shared.Task;
import java.util.List;

public class Task03 implements Task {

    @Override
    public long partOne(List<String> input) {
        return input
            .stream()
            .map(Bank::new)
            .map(Bank::joltage)
            .mapToInt(Integer::intValue)
            .sum();
    }

    @Override
    public long partTwo(List<String> input) {
        return -1;
    }
}
