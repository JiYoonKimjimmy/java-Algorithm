package algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class BfsSample_01 {

    private static List<List<Integer>> graph;
    private static boolean[] checked;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        checked[start] = true;

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            System.out.println(vertex);

            for (int e : graph.get(vertex)) {
                if (checked[e] == false) {
                    checked[e] = true;
                    queue.offer(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edge = sc.nextInt();

        GraphSample_01 Graph = new GraphSample_01(vertex, edge);

        graph = Graph.setGraph();

        checked = new boolean[vertex + 1];

        Graph.printGraph(graph);

        bfs(1);
    }
}
