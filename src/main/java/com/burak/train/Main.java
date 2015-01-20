package com.burak.train;

import static org.junit.Assert.assertEquals;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Graph graph;
	static Node a, b, c, d, e;

	public static void main(String[] args) {
		graph = new Graph();
		a = new Node("A");
		b = new Node("B");
		c = new Node("C");
		d = new Node("D");
		e = new Node("E");

		// Define distance from nodes

		graph.routeTable.put(a, new Edge(a, b, 5).next(new Edge(a, d, 5)
				.next(new Edge(a, e, 7))));
		graph.routeTable.put(b, new Edge(b, c, 4));
		graph.routeTable.put(c, new Edge(c, d, 8).next(new Edge(c, e, 2)));
		graph.routeTable.put(d, new Edge(d, c, 8).next(new Edge(d, e, 6)));
		graph.routeTable.put(e, new Edge(e, b, 3));

		System.out.println("Choose Input Number : ");

		Scanner s = new Scanner(System.in);
		int i = s.nextInt();

		ArrayList<Node> route = new ArrayList<Node>();

		
			switch (i) {
			case 1:
				route.add(a);
				route.add(b);
				route.add(c);
				if (graph.getDistance(route) != 0) {
					System.out
					.print("OUTPUT - 1 : " + graph.getDistance(route));
				}
				else {
					System.out.println("OUTPUT - 1 : NO SUCH ROUTE");
				}
				

				break;
			case 2:
				route.add(a);
				route.add(d);
				if (graph.getDistance(route) != 0) {
					System.out
					.print("OUTPUT - 2 : " + graph.getDistance(route));
				}
				else {
					System.out.println("OUTPUT - 2 : NO SUCH ROUTE");
				}
				

				break;
			case 3:
				route.add(a);
				route.add(d);
				route.add(c);
				if (graph.getDistance(route) != 0) {
					System.out
					.print("OUTPUT - 3 : " + graph.getDistance(route));
				}
				else {
					System.out.println("OUTPUT - 3 : NO SUCH ROUTE");
				}
				

				break;
			case 4:
				route.add(a);
				route.add(e);
				route.add(b);
				route.add(c);
				route.add(d);
				if (graph.getDistance(route) != 0) {
					System.out
					.print("OUTPUT - 4 : " + graph.getDistance(route));
				}
				else {
					System.out.println("OUTPUT - 4 : NO SUCH ROUTE");
				}

				break;
			case 5:
				route.add(a);
				route.add(e);
				route.add(d);
				if (graph.getDistance(route) != 0) {
					System.out
					.print("OUTPUT - 5 : " + graph.getDistance(route));
				}
				else {
					System.out.println("OUTPUT - 5 : NO SUCH ROUTE");
				}
				

				break;
			case 6:
				int num6 = graph.numStops(c, c, 3);
				System.out.print("OUTPUT - 6 : " + num6);

				break;
			case 7:
				int num7 = graph.numStops(a, c, 4);
				System.out.print("OUTPUT - 7 : " + num7);

				break;
			case 8:
				int shortestRoute = graph.shortestRoute(a, c);
				System.out
						.print("OUTPUT - 8 : " + shortestRoute);

				break;
			case 9:
				int shortestRoute1 = graph.shortestRoute(b, b);
				System.out
						.print("OUTPUT - 9 : " + shortestRoute1);

				break;
			case 10:
				int numRoutesWithin = graph.numRoutesWithin(c, c, 30);
				System.out.print("OUTPUT - 10 : "
						+ numRoutesWithin);

				break;

			default:
				System.out
				.print("WRONG INPUT");
				break;
			}

	}
}
