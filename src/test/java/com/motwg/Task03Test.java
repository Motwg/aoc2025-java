package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task03.Task03;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task03Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task03();
        this.id = "03";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(357, task.partOne(input));
        assertEquals(3121910778619L, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(17321, task.partOne(input));
        assertEquals(171989894144198L, task.partTwo(input));
    }
}
