package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task00.Task00;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task00Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task00();
        this.id = "00";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(0, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(0, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }
}
