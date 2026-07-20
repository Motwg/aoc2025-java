package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task07.Task07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task07Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task07();
        this.id = "07";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(21, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(1642, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }
}
