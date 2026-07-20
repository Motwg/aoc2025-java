package com.motwg.task07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.motwg.shared.Task;

public class Task07 implements Task {

    @Override
    public long partOne(List<String> input) {
        Map<Integer, Character> line = charMap(input.get(0));
        long counter = start(line);
        for (int i = 1; i < input.size(); ++i) {
            Map<Integer, Character> prevLine = line;
            line = charMap(input.get(i));
            counter += split(line, prevLine);
        }
        return counter;
    }

    public Map<Integer, Character> charMap(String input) {
        return IntStream.range(0, input.length())
            .boxed()
            .collect(Collectors.toMap(i -> i, input::charAt))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() != '.')
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public long split(Map<Integer, Character> line, Map<Integer, Character> prevLine) {
        long counter = 0;
        for (Map.Entry<Integer, Character> ch : prevLine.entrySet()) {
            if (ch.getValue() == '|') {
                if(line.getOrDefault(ch.getKey(), '.') == '^') {
                    line.put(ch.getKey() - 1, '|');
                    line.put(ch.getKey() + 1, '|');
                    counter += 1;
                    line.remove(ch.getKey());
                } else if(ch.getValue() == '|'){
                    line.put(ch.getKey(), '|');
                }
            }
        }

        return counter;
    }

    public long start(Map<Integer, Character> line) {
        line.entrySet().forEach(entry -> entry.setValue('|'));
        return 0L;
    }

    @Override
    public long partTwo(List<String> input) {
        return -1;
    }
}
