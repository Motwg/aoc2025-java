package com.motwg.task02;

public class Range {

    private long from;
    private long to;

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public Range(String string) {
        String[] stringRange = string.split("-");
        this.from = Long.parseLong(stringRange[0]);
        this.to = Long.parseLong(stringRange[1]);
    }
}
