package com.burak.train;

public class Edge {
	// Origin node
	public Node origin;
	// Destination node
	public Node destination;
	// Route weight to destination
	public int weight;
	// next possible route
	public Edge next;

	// constructor
	public Edge(Node origin, Node destination, int weight) {
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.next = null;
	}

	public Edge next(Edge edge) {
		this.next = edge;
		return this;
	}
}