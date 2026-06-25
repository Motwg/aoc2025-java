package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task02.Task02;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task02Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task02();
        this.id = "02";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(1227775554, task.partOne(input));
        assertEquals(4174379265L, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(30608905813L, task.partOne(input));
        assertEquals(0, task.partTwo(input));
    }
}
