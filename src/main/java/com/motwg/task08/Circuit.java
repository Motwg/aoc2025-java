package com.motwg.task08;

import java.util.HashSet;
import java.util.Set;;

public class Circuit {
    private Set<Integer> boxes;

    public Circuit() {
        boxes = new HashSet<>();
    }

    public Circuit(int[] ids) {
        boxes = new HashSet<>();
        for (int id : ids) {
            boxes.add(id);
        }
    }

    public Circuit join(Circuit other) {
        this.boxes.addAll(other.boxes);
        return this;
    }

    public Status isBoxConnected(int id) {
        return boxes.contains(id) ? Status.CONNECTED : Status.DISCONNECTED;
    }

    public void add(int id) {
        boxes.add(id);
    }

    public int size() {
        return boxes.size();
    }

    public String toString() {
        return boxes.toString();
    }
}
