package com.motwg.task08;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Teleporter {

    private List<Circuit> circuits;

    public List<Circuit> getCircuits() {
		return circuits;
	}

	public Teleporter() {
        circuits = new LinkedList<>();
    }

    public void add(Point circuit_ids) {
        int firstId = (int) circuit_ids.getX();
        int secondId = (int) circuit_ids.getY();
        Status first = isBoxConnected(firstId);
        Status second = isBoxConnected(secondId);

        if (!first.isConnected() && !second.isConnected()) {
            Circuit circuit = new Circuit(new int[]{firstId, secondId});
            circuits.add(circuit);
        } else if (first.isConnected() && second.isConnected()) {
            joinCircuits(firstId, secondId);
        } else if (first.isConnected()) {
            findAndConnect(firstId, secondId);
        } else {
            findAndConnect(secondId, firstId);
        }
    }

    public Status isBoxConnected(int id) {
        return circuits.stream().anyMatch(c -> c.isBoxConnected(id).isConnected())
            ? Status.CONNECTED : Status.DISCONNECTED;
    }

    public int size() {
        return circuits.stream().mapToInt(Circuit::size).sum();
    }

    public String toString() {
        return circuits.stream()
            .map(Circuit::toString)
            .collect(Collectors.joining());
    }

    private void findAndConnect(int insider, int outsider) {
        circuits.stream()
            .filter(c -> c.isBoxConnected(insider).isConnected())
            .findFirst()
            .get()
            .add(outsider);
    }

    private void joinCircuits(int first, int second) {
        List<Integer> indexes = IntStream.range(0, circuits.size())
            .filter(i -> circuits.get(i).isBoxConnected(first).isConnected()
                || circuits.get(i).isBoxConnected(second).isConnected())
            .boxed()
            .collect(Collectors.toList());
        if (indexes.size() == 2) {
            circuits.get(indexes.get(0)).join(circuits.remove((int) indexes.get(1)));
        }
    }
}
