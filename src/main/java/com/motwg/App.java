package com.motwg;

import com.motwg.shared.LineReader;
import com.motwg.task02.Task02;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> input = LineReader.readFile("resources/input02.txt");
        int output = new Task02().partOne(input);

        System.out.println(output);
    }
}
