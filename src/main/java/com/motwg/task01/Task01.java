package com.motwg.task01;

import com.motwg.shared.Task;
import java.util.List;

public class Task01 implements Task {

    @Override
    public long partOne(List<String> input) {
        Vault v = new Vault();
        input
            .stream()
            .map(Action::new)
            .forEach(a -> {
                v.performAction(a);
            });
        return v.getClicks();
    }

    @Override
    public long partTwo(List<String> input) {
        Vault v = new Vault(true);
        input
            .stream()
            .map(Action::new)
            .forEach(a -> {
                v.performAction(a);
            });
        return v.getClicks();
    }
}
