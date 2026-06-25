package com.motwg.task02;

import com.motwg.shared.Task;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Task02 implements Task {

    public long shared(List<String> input, InvalidIdGen iig) {
        return Stream.of(String.join(",", input).split(","))
            .filter(str -> str != "")
            .peek(System.out::println)
            .map(Range::new)
            .map(iig::fromRange)
            .reduce(LongStream.empty(), LongStream::concat)
            .sum();
    }

    @Override
    public long partOne(List<String> input) {
        InvalidIdGen iig = new InvalidIdGen(IdMethod.Dbl);
        return shared(input, iig);
    }

    @Override
    public long partTwo(List<String> input) {
        InvalidIdGen iig = new InvalidIdGen(IdMethod.atLeastDbl);
        return shared(input, iig);
    }
}
