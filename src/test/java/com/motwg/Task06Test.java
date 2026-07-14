package com.motwg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.motwg.shared.LineReader;
import com.motwg.shared.Task;
import com.motwg.task06.Task06;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task06Test {

    private Task task;
    private String id;

    @BeforeEach
    public void setUp() {
        this.task = new Task06();
        this.id = "06";
    }

    @Test
    public void testExample() {
        List<String> input = LineReader.readFile(
            "resources/test" + this.id + ".txt"
        );

        assertEquals(4277556, task.partOne(input));
        assertEquals(3263827, task.partTwo(input));
    }

    @Test
    public void testInput() {
        List<String> input = LineReader.readFile(
            "resources/input" + this.id + ".txt"
        );

        assertEquals(5595593539811L, task.partOne(input));
        assertEquals(10153315705125L, task.partTwo(input));
    }
}
