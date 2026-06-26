package com.motwg.task03;

import com.motwg.shared.Task;
import java.util.List;

public class Task03 implements Task {

    @Override
    public long partOne(List<String> input) {
        return input
            .stream()
            .map(Bank::new)
            .map(b -> b.turnOn(2))
            .mapToLong(Long::longValue)
            .sum();
    }

    @Override
    public long partTwo(List<String> input) {
        return input
            .stream()
            .map(Bank::new)
            .map(b -> b.turnOn(12))
            .mapToLong(Long::longValue)
            .sum();
    }
}
