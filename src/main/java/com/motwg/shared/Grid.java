package com.motwg.shared;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Grid<V> implements Iterable<Map.Entry<Point, V>> {

    private final Map<Point, V> grid = new LinkedHashMap<Point, V>();

    @Override
    public Iterator<Entry<Point, V>> iterator() {
        return grid.entrySet().iterator();
    }

    public V get(int i, int j) {
        return grid.get(new Point(i, j));
    }

    public V getOrDefault(int i, int j, V defaultV) {
        return grid.getOrDefault(new Point(i, j), defaultV);
    }

    public V set(int i, int j, V value) {
        return grid.put(new Point(i, j), value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Point, V> entry : this) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
