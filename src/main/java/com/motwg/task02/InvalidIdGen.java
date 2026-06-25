package com.motwg.task02;

import java.util.function.LongPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class InvalidIdGen {

    private LongPredicate predicate;

    public InvalidIdGen(IdMethod idMethod) {
        switch (idMethod) {
            case Dbl: {
                predicate = InvalidIdGen::isInvalid;
                break;
            }
            case atLeastDbl: {
                predicate = InvalidIdGen::isMultiInvalid;
                break;
            }
        }
    }

    public LongStream fromRange(Range range) {
        return LongStream.rangeClosed(range.getFrom(), range.getTo()).filter(
            predicate
        );
    }

    public static Boolean isInvalid(long integer) {
        String asString = String.valueOf(integer);
        return (
            asString
                .substring(0, asString.length() / 2)
                .compareTo(asString.substring(asString.length() / 2)) == 0
        );
    }

    public static Boolean isMultiInvalid(long integer) {
        String asString = String.valueOf(integer);
        long patterns = IntStream.rangeClosed(1, asString.length() / 2)
            .filter(digits -> {
                return asString.matches(
                    "^(" + asString.substring(0, digits) + ")*$"
                );
            })
            .count();
        return patterns > 0;
    }
}
