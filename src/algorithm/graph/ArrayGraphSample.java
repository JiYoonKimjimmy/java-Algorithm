package algorithm.graph;

import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2020-01-31
 */
public class ArrayGraphSample {
    private static int[][] graph;
    private static int vertex;
    private static int edge;
    private static Scanner scanner;

    public ArrayGraphSample() {
        initGraph();
    }

    public int[][] getGraph() {
        return graph;
    }

    public void initGraph() {
        scanner = new Scanner(System.in);

        System.out.print("총 정점 수 : ");
        vertex = scanner.nextInt();
        System.out.print("총 간선 수 : ");
        edge = scanner.nextInt();

        graph = new int[vertex + 1][vertex + 1];

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
        graph[x][y] = graph[y][x] = w;
    }

    public void putSingle(int x, int y, int w) {
        graph[x][y] = w;
    }

    public void printGraph() {
        System.out.println();
        System.out.println("---------------------");
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------");
        System.out.println();
    }
}
