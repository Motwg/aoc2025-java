package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task04.Task04;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task04Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task04();
        this.id = "04";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(13, task.partOne(input));
        assertEquals(43, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(1505, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }
}
