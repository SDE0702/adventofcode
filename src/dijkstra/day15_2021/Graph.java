package dijkstra.day15_2021;

import java.util.HashSet;
import java.util.Set;

public class Graph {

	private Set nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

	@Override
	public String toString() {
		return nodes.toString();
	}
    
    
}
