package algorithm.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        return graph;
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
        for (int i = 0; i < graph.size(); i++) {
            List<Integer> item = graph.get(i);
            System.out.print(i + " : ");
            for (int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + ", ");
            }
            System.out.println();
        }
        System.out.println("---------------------");

    }

    public static void main(String[] args) {

    }
}