package com.burak.train;

public class Node {
	public String name;
	public boolean visited;

	public Node(String name) {
		this.name = name;
		this.visited = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		Node node = (Node) obj;
		return this.name.equals(node.name);
	}

	@Override
	public int hashCode() {
		if (this.name == null)
			return 0;
		return this.name.hashCode();
	}
}