package algorithm.graph;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class GraphSample_01 {
    private static int vertex;
    private static int edge;

    public GraphSample_01(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    public List<List<Integer>> setGraph() {
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            System.out.print("정점 : ");
            int x = sc.nextInt();
            System.out.print("인접정점 : ");
            int y = sc.nextInt();

            put(graph, x, y);
        }

        return graph;
    }

    public void put(List<List<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public void putSingle(List<List<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
    }

    public List<List<Pair<Integer, Integer>>> setGraphWithWeight() {
        Scanner sc = new Scanner(System.in);

        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            graph.get(x).add(new Pair<>(y, w));
            graph.get(y).add(new Pair<>(x, w));
        }

        return graph;
    }

    public void printGraph(List<List<Integer>> graph) {
        System.out.println();
        System.out.println("---------------------");
        for (int i = 1; i < graph.size(); i++) {
            List<String> printList = new LinkedList<>();

            List<Integer> item = graph.get(i);
            System.out.print(i + " : ");
            item.stream().forEach(e -> printList.add(String.valueOf(e)));

            System.out.println(String.join(", ", printList));
        }
        System.out.println("---------------------");
        System.out.println();
    }
}