package com.burak.train;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
	public Hashtable<Node, Edge> routeTable;

	public Graph() {
		this.routeTable = new Hashtable<Node, Edge>();
	}

	// This method calculate the distance of nodes

	public int getDistance(ArrayList<Node> node) {

		// if node = 0 or 1

		if (node.size() < 2)
			return 0;
		int distance, depth, i;
		distance = depth = i = 0;

		// Check data in hash

		while (i < node.size() - 1) {
			if (this.routeTable.containsKey(node.get(i))) {
				Edge route = this.routeTable.get(node.get(i));
				/*
				 * if node(i+1) in our destination increment distance and node
				 * count
				 */
				while (route != null) {
					if (route.destination.equals(node.get(i + 1))) {
						distance += route.weight;
						depth++;
						break;
					}
					route = route.next;
				}
			} else
				return 0;
			i++;
		}
		/*
		 * if destination has n node depth must be bigger than (node_size - 1)
		 */
		if (depth != node.size() - 1)
			return 0;

		return distance;

	}

	// Number of stops;
	public int numStops(Node start, Node end, int maxStops) {
		// Wrapper to all meets the conditions
		return findRoutes(start, end, 0, maxStops);
	}

	// This method will find routes
	private int findRoutes(Node start, Node end, int depth, int maxStops) {
		int routes = 0;
		// Check here, start and end nodes exists in route table
		if (this.routeTable.containsKey(start)
				&& this.routeTable.containsKey(end)) {
			/*
			 * If start node exists all possible routes check if it is
			 * destination? If destination, and number of stops within allowed
			 * limits, count it as possible route.
			 */
			depth++;
			if (depth > maxStops) // Check if depth level is within limits
				return 0;
			start.visited = true; // Start node as visited
			Edge edge = this.routeTable.get(start);
			while (edge != null) {
				/*
				 * If destination right, then increment route count, then
				 * continue to next node for same depth
				 */
				if (edge.destination.equals(end)) {
					routes++;
					edge = edge.next;
					continue;
				}
				/*
				 * If destination does not right, and destination node has not
				 * yet been visited, we change destination node
				 */
				else if (!edge.destination.visited) {
					routes += findRoutes(edge.destination, end, depth, maxStops);
					depth--;
				}
				edge = edge.next;
			}
		} else
			return 0;

		// Before exiting mark the start node not visited.

		start.visited = false;
		return routes;
	}

	// Shortest route

	public int shortestRoute(Node start, Node end) {
		// Wrapper to weight
		return findShortestRoute(start, end, 0, 0);

	}

	// This method will be found shortest route between two nodes

	private int findShortestRoute(Node start, Node end, int weight,
			int shortestRoute) {
		// Check here, start and end nodes exists in route table
		if (this.routeTable.containsKey(start)
				&& this.routeTable.containsKey(end)) {
			/*
			 * If start node exists then look all possible routes and check if
			 * it is destination
			 */

			start.visited = true; // Start node as visited
			Edge edge = this.routeTable.get(start);
			while (edge != null) {
				// If node not visited or is the destination, increment
				// weight
				if (edge.destination == end || !edge.destination.visited)
					weight += edge.weight;

				/*
				 * If destination matches, compare weight of this route to
				 * shortest route or not, if not switch
				 */
				if (edge.destination.equals(end)) {
					if (shortestRoute == 0 || weight < shortestRoute)
						shortestRoute = weight;
					start.visited = false; // Unvisit node and return shortest
					return shortestRoute;
				}
				/*
				 * If destination does not match, and node not visited, change node
				 */
				else if (!edge.destination.visited) {
					shortestRoute = findShortestRoute(edge.destination, end,
							weight, shortestRoute);
					// Decrement weight as we give up
					weight -= edge.weight;
				}
				edge = edge.next;
			}
		} else
			return 0;

		// Set start node unvisited again
		start.visited = false;
		return shortestRoute;

	}

	/*
	 * Shortest route; for max distance
	 */
	public int numRoutesWithin(Node start, Node end, int maxDistance) {
		// Wrapper to all meets the conditions
		return findnumRoutesWithin(start, end, 0, maxDistance);
	}

	/*
	 * Finds the shortest route between two nodes
	 */
	private int findnumRoutesWithin(Node start, Node end, int weight,
			int maxDistance) {
		int routes = 0;
		// Check if start and end nodes exists in route table
		if (this.routeTable.containsKey(start)
				&& this.routeTable.containsKey(end)) {
			/*
			 * If start node exists then look all possible routes and check if
			 * it is destination
			 */
			Edge edge = this.routeTable.get(start);
			while (edge != null) {
				weight += edge.weight;
				/*
				 * If distance is under the max, and  if there found node until distance > max continue
				 */
				if (weight <= maxDistance) {
					if (edge.destination.equals(end)) {
						routes++;
						routes += findnumRoutesWithin(edge.destination, end,
								weight, maxDistance);
						edge = edge.next;
						continue;
					} else {
						routes += findnumRoutesWithin(edge.destination, end,
								weight, maxDistance);
						weight -= edge.weight; // Decrement weight as we give up
												
					}
				} else
					weight -= edge.weight;

				edge = edge.next;
			}
		} else
			return 0;

		return routes;

	}
}