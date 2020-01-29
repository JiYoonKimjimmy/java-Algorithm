package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jim, Kim
 * @since 2020-01-28
 */
public class GraphSample_02 {
    public static void main(String[] args) {
        Graph graph = new Graph().createGraph();

        List<String> adjVertices = graph.getAdjVertices("1");

        adjVertices.stream().forEach(e -> System.out.println(e));
    }
}

class Graph {
    private Map<String, List<String>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    void addVertex(String vertax) {
        // HashMap.putIfAbsent() : 해당 key 값의 데이터가 있는 경우 insert, 없는 경우 return
        adjVertices.putIfAbsent(vertax, new ArrayList<>());
    }

    void removeVertex(String vertax) {
        adjVertices.remove(vertax);
    }

    void addEdge(String vertax1, String vertax2) {
        adjVertices.get(vertax1).add(vertax2);
        adjVertices.get(vertax2).add(vertax1);
    }

    void removeEdge(String vertax1, String vertax2) {
        List<String> eV1 = adjVertices.get(vertax1);
        List<String> eV2 = adjVertices.get(vertax2);

        if (eV1 != null) eV1.remove(vertax2);
        if (eV2 != null) eV2.remove(vertax1);
    }

    Graph createGraph() {
        Graph graph = new Graph();

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        // 1 -> 5 -> 2 => 4 => 3 -> 6
        graph.addEdge("1", "5");
        graph.addEdge("5", "2");
        graph.addEdge("2", "4");
        graph.addEdge("4", "3");
        graph.addEdge("3", "6");

        return graph;
    }

    List<String> getAdjVertices(String vertex) {
        return adjVertices.get(vertex);
    }
}
