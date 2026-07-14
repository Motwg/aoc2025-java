package com.motwg.task06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.motwg.shared.Task;

public class Task06 implements Task {

    @Override
    public long partOne(List<String> input) {
        List<Iterator<String>> iterators = input.stream()
            .map(s -> Arrays.stream(s.strip().replaceAll("\\s+", " ").split(" "))
                .iterator())
            .collect(Collectors.toList());

        Iterator<String> operators = iterators.remove(iterators.size() - 1);

        long sum = 0;
        while (operators.hasNext()) {
            String operator = operators.next();
            sum += iterators.stream()
                .mapToLong(s -> Long.valueOf(s.next()))
                .reduce((v1, v2)-> operator.compareTo("+") == 0 ? v1 + v2 : v1 * v2)
                .orElseThrow();
        }

        return sum;
    }

    @Override
    public long partTwo(List<String> input) {
        List<Iterator<Integer>> iterators = input.stream()
            .limit(input.size() - 1)
            .map(s -> s.chars().iterator())
            .collect(Collectors.toList());

        String[] operators = input.get(input.size() - 1).replaceAll("\\s+", " ").split(" ");

        Long sum = 0L;
        List<Long> values = new ArrayList<>();
        for (String operator : operators) {
            String representation = " ";

            while (representation.length() != 0) {
                representation = iterators.stream()
                    .filter(it -> it.hasNext())
                    .map(it -> it.next())
                    .filter(ch -> ch != ' ')
                    .map(ch -> String.valueOf(ch - 48))
                    .collect(Collectors.joining());
                System.out.println(representation + ": " + representation.length());
                if (representation.length() > 0) {
                    values.add(Long.valueOf(representation));
                }
            }
            System.out.println(operator + " : " + values);

            sum += values.stream()
                .reduce((v1, v2)-> operator.compareTo("+") == 0 ? v1 + v2 : v1 * v2)
                .orElseThrow();
            values.clear();
        }

        return sum;
    }
}
