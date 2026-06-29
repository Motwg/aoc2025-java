package com.motwg.shared;

public class Range {

    private long from;
    private long to;

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public boolean inInclusive(long value) {
        return value >= from && value <= to;
    }

    public boolean inExclusive(long value) {
        return value > from && value < to;
    }

    public Range(String string) {
        String[] stringRange = string.split("-");
        this.from = Long.parseLong(stringRange[0]);
        this.to = Long.parseLong(stringRange[1]);
    }
}
