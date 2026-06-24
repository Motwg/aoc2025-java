package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task01.Task01;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task01Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task01();
        this.id = "01";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(3, task.partOne(input));
        assertEquals(6, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(1043, task.partOne(input));
        assertEquals(5963, task.partTwo(input));
    }
}
