package com.motwg.task02;

import com.motwg.shared.Task;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Task02 implements Task {

    @Override
    public long partOne(List<String> input) {
        InvalidIdGen iig = new InvalidIdGen();
        return (
            Stream.of(String.join(",", input).split(","))
                .filter(str -> str != "")
                .peek(System.out::println)
                .map(Range::new)
                .map(iig::fromRange)
                // .peek(System.out::println)
                .reduce(LongStream.empty(), LongStream::concat)
                // .peek(System.out::println)
                .sum()
        );
    }

    @Override
    public long partTwo(List<String> input) {
        return -1;
    }
}
