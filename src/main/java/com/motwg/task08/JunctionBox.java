package com.motwg.task08;

public class JunctionBox {
    private int x;
    private int y;
    private int z;

    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public JunctionBox(String string) {
        String[] parts = string.split(",");
        this.x = Integer.valueOf(parts[0]);
        this.y = Integer.valueOf(parts[1]);
        this.z = Integer.valueOf(parts[2]);
    }

    public Double distance(JunctionBox other) {
        return Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2);
    }
}
