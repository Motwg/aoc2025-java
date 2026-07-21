package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task08.Task08;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task08Test {

    private Task08 task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task08();
        this.id = "08";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(40, task.partOne(input, 10));
        assertEquals(25272, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(84968, task.partOne(input, 1000));
        assertEquals(8663467782L, task.partTwo(input));
    }
}
