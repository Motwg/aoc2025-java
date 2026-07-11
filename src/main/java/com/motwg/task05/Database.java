package com.motwg.task05;

import com.motwg.shared.Range;
import com.motwg.shared.RangeSequence;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private List<Range> ranges;
    private List<Long> ids;

    public Database(List<String> input) {
        this.ranges = new LinkedList<>();
        this.ids = new LinkedList<>();

        Iterator<String> itr = input.iterator();
        Boolean split = false;

        while (itr.hasNext()) {
            String next = itr.next();
            if (split) {
                ids.add(Long.valueOf(next));
            } else if (next.length() == 0) {
                split = true;
            } else {
                ranges.add(new Range(next));
            }
        }
    }

    public long countFresh() {
        return ids
            .stream()
            .filter(id -> ranges.stream().anyMatch(r -> r.inInclusive(id)))
            .count();
    }

    public long countConsideredFresh() {
        return new RangeSequence(ranges).countInclusive();
    }
}
