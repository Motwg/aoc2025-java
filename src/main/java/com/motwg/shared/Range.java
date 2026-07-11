package com.motwg.shared;

public class Range {

    private long from;
    private long to;

    public Range(String string) {
        String[] stringRange = string.split("-");
        this.from = Long.parseLong(stringRange[0]);
        this.to = Long.parseLong(stringRange[1]);
    }

    public Range(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public boolean inInclusive(long value) {
        return value >= from && value <= to;
    }

    public boolean inExclusive(long value) {
        return value > from && value < to;
    }

    public long count() {
        return to - from;
    }

    public long countInclusive() {
        return count() + 1;
    }

    public long countExclusive() {
        return count() - 1;
    }

    public String toString() {
        return from + "-" + to;
    }
}
