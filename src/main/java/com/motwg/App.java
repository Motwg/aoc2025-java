package com.motwg;

import com.motwg.shared.LineReader;
import com.motwg.task03.Task03;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> input = LineReader.readFile("resources/test03.txt");
        long output = new Task03().partOne(input);

        System.out.println(output);
    }
}
