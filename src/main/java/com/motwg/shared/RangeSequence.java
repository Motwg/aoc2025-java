package com.motwg.shared;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RangeSequence implements Iterable<Range> {

    private List<Range> sequence;

    public RangeSequence() {
        this.sequence = new LinkedList<>();
    }

    public RangeSequence(List<Range> ranges) {
        this();
        ranges.stream().forEach(this::add);
    }

    public void add(Range range) {
        Iterator<Range> iter = iterator();
        Boolean done = false;

        for (int i = 0; iter.hasNext(); ++i) {
            Range current = iter.next();
            if (range.getFrom() > current.getTo()) {
                continue;
            } else if (range.getTo() < current.getFrom()) {
                if (!done) {
                    sequence.add(i, range);
                    done = true;
                }
                break;
            } else {
                if (range.getFrom() < current.getFrom()) {
                    current.setFrom(range.getFrom());
                    done = true;
                }
                if (range.getTo() > current.getTo()) {
                    current.setTo(range.getTo());
                    done = true;
                }
            }
        }

        if (!done) {
            sequence.add(range);
        }
        sequence = reduce(sequence);
    }

    private List<Range> reduce(List<Range> ranges) {
        return ranges.stream().collect(
            LinkedList<Range>::new,
            (acc, r) -> {
                if (acc.isEmpty()) {
                    acc.add(r);
                } else {
                    Range r0 = acc.getLast();
                    if (r.getFrom() <= r0.getTo()) {
                        acc.removeLast();
                        acc.add(
                            new Range(
                                Math.min(r.getFrom(), r0.getFrom()),
                                Math.max(r.getTo(), r0.getTo())
                            )
                        );
                    } else {
                        acc.add(r);
                    }
                }
            },
            (acc, r) -> {
                throw new UnsupportedOperationException();
            }
        );
    }

    public long count() {
        return sequence.stream().mapToLong(Range::count).sum();
    }

    public long countInclusive() {
        return sequence.stream().mapToLong(Range::countInclusive).sum();
    }

    public long countExclusive() {
        return sequence.stream().mapToLong(Range::countExclusive).sum();
    }

    @Override
    public Iterator<Range> iterator() {
        return sequence.iterator();
    }

    public String toString() {
        return sequence
            .stream()
            .map(Range::toString)
            .collect(Collectors.joining(" / "));
    }
}
