package algorithm.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2020-01-30
 */
public class ListGraphSample {
    private static List<List<Pair<Integer, Integer>>> graph;
    private static int vertex;
    private static int edge;
    private static Scanner scanner;

    public ListGraphSample() {
        initGraph();
    }

    public int getVertex() {
        return vertex;
    }

    public List<List<Pair<Integer, Integer>>> getGraph() {
        return graph;
    }

    public void initGraph() {
        scanner = new Scanner(System.in);

        System.out.print("총 정점 수 : ");
        vertex = scanner.nextInt();
        System.out.print("총 간선 수 : ");
        edge = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        setGraph();
    }

    public void setGraph() {

        for (int i = 0; i < edge; i++) {
            System.out.println("[" + i + "] 번째 간선 정보 입력..");
            System.out.print("[정점] : ");
            int x = scanner.nextInt();
            System.out.print("[인접정점] : ");
            int y = scanner.nextInt();
            System.out.print("[가중치] : ");
            int w = scanner.nextInt();

            put(x, y, w);
        }

        printGraph();
    }

    public void put(int x, int y, int w) {
        graph.get(x).add(new Pair<>(y, w));
        graph.get(y).add(new Pair<>(x, w));
    }

    public void putSingle(int x, int y, int w) {
        graph.get(x).add(new Pair<>(y, w));
    }

    public void setGraphWithWeight() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < edge; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            put(x, y, w);
        }
    }

    public void printGraph() {
        System.out.println();
        System.out.println("---------------------");
        for (int i = 1; i < graph.size(); i++) {
            List<String> printList = new LinkedList<>();

            List<Pair<Integer, Integer>> item = graph.get(i);
            System.out.print(i + " : ");
            item.stream().forEach(e -> printList.add(String.valueOf(e)));

            System.out.println(String.join(", ", printList));
        }
        System.out.println("---------------------");
        System.out.println();
    }
}