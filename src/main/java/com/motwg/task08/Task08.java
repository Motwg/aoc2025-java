package com.motwg.task08;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.motwg.shared.Grid;

public class Task08  {

    public long partOne(List<String> input, int limiter) {
        Map<Integer, JunctionBox> boxes = IntStream.range(0, input.size())
            .boxed()
            .collect(Collectors.toMap(Function.identity(), i -> new JunctionBox(input.get(i))));
        Stream<Entry<Point, Double>> distances = countDistances(boxes);

        Teleporter teleporter = new Teleporter();
        distances.limit(limiter).forEachOrdered(d -> {
            teleporter.add(d.getKey());
        });
        return teleporter.getCircuits().stream()
            .map(Circuit::size)
            .sorted((s1, s2) -> s2.compareTo(s1))
            .limit(3)
            .reduce(1, (v1, v2) -> v1 * v2);
    }

    public Stream<Entry<Point, Double>> countDistances(Map<Integer, JunctionBox> boxes) {
        Grid<Double> distances = new Grid<>();
        for (int i = 0; i < boxes.size(); ++i) {
            for (int j = i + 1; j < boxes.size(); ++j) {
                distances.set(i, j, boxes.get(i).distance(boxes.get(j)));
            }
        }
        return distances.entrySet().stream()
            .sorted((d1, d2) -> d1.getValue().compareTo(d2.getValue()));
    }

    public long partTwo(List<String> input) {
        Map<Integer, JunctionBox> boxes = IntStream.range(0, input.size())
            .boxed()
            .collect(Collectors.toMap(Function.identity(), i -> new JunctionBox(input.get(i))));
        Iterator<Entry<Point, Double>> distances = countDistances(boxes).iterator();

        Teleporter teleporter = new Teleporter();
        Point last = new Point(0, 0);
        while (teleporter.getCircuits().size() != 1 || teleporter.size() != input.size()) {
            last = distances.next().getKey();
            teleporter.add(last);
        }
        return ((long) boxes.get((int) last.getX()).getX()) * ((long) boxes.get((int) last.getY()).getX());
    }
}
