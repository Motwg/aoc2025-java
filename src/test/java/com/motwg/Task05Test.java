package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task05.Task05;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task05Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task05();
        this.id = "05";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(3, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(635, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }
}
