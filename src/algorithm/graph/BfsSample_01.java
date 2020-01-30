package algorithm.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class BfsSample_01 {
    private static List<String> printList;
    private static List<List<Pair<Integer, Integer>>> graph;
    private static boolean[] checked;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        checked[start] = true;

        printList = new LinkedList<>();

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            printList.add(String.valueOf(vertex));

            for (Pair<Integer, Integer> e : graph.get(vertex)) {
                int k = e.getKey();
                if (checked[k] == false) {
                    checked[k] = true;
                    queue.offer(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("총 정점 수 : ");
        int vertex = sc.nextInt();
        System.out.print("총 간선 수 : ");
        int edge = sc.nextInt();

        ListGraphSample listGraphSample = new ListGraphSample(vertex, edge);
        graph = listGraphSample.setGraph();

        checked = new boolean[vertex + 1];

        listGraphSample.printGraph(graph);

        bfs(1);

        System.out.println("result of BFS : " + String.join(" -> ", printList));
    }
}
