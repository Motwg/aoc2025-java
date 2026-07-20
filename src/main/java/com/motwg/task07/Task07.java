package com.motwg.task07;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.motwg.shared.Task;

import javafx.util.Pair;

public class Task07 implements Task {

    @Override
    public long partOne(List<String> input) {
        Map<Integer, Character> line = start(charMap(input.get(0)))
            .stream()
            .collect(Collectors.toMap(Function.identity(), beam -> '|'));
        long counter = 0;
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

    public List<Integer> start(Map<Integer, Character> line) {
        List<Integer> beams = line.entrySet().stream()
            .filter(entry -> entry.getValue() == 'S')
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
        return beams;
    }

    @Override
    public long partTwo(List<String> input) {
        Map<Integer, Long> beams = quantizeBeam(start(charMap(input.get(0))));
        for (int i = 1; i < input.size(); ++i) {
            Map<Integer, Character> line = charMap(input.get(i));
            beams = quantumSplit(beams, line);
        }
        return beams.entrySet().stream()
            .mapToLong(p -> p.getValue())
            .sum();
    }

    public Map<Integer, Long> quantizeBeam(List<Integer> beams) {
        return beams.stream().collect(Collectors.toMap(Function.identity(), b -> 1L));
    }

    public Map<Integer, Long> quantumSplit(Map<Integer, Long> beams, Map<Integer, Character> line) {
        return beams.entrySet().stream()
            .map(b -> new Pair<Integer, Long>(b.getKey(), b.getValue()))
            .flatMap(b -> {
                if (line.containsKey(b.getKey())) {
                    return Stream.of(
                        new Pair<Integer, Long>(b.getKey() - 1, b.getValue()),
                        new Pair<Integer, Long>(b.getKey() + 1, b.getValue())
                    );
                }
                return Stream.of(b);
            })
            .collect(Collectors.toMap(b -> b.getKey(), b -> b.getValue(), (v1, v2) -> v1 + v2));
    }
}
