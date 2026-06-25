package com.motwg.task02;

import java.util.stream.LongStream;

public class InvalidIdGen {

    public LongStream fromRange(Range range) {
        return LongStream.rangeClosed(range.getFrom(), range.getTo()).filter(
            this::isInvalid
        );
    }

    public Boolean isInvalid(long integer) {
        String asString = String.valueOf(integer);
        System.out.println(
            asString +
                "  =>  " +
                asString.substring(0, (int) (asString.length() / 2)) +
                " == " +
                asString.substring((int) (asString.length() / 2))
        );
        return (
            asString
                .substring(0, asString.length() / 2)
                .compareTo(asString.substring(asString.length() / 2)) == 0
        );
    }

    public Boolean isMultiInvalid(long integer) {
        String asString = String.valueOf(integer);

        return false;
    }

    public int generate(int digits) {
        int a = digits / 2;
        System.out.println(a);
        return 0;
    }
}
