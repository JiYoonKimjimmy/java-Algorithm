package algorithm.graph;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class DfsSample_01 {

    private static List<List<Pair<Integer, Integer>>> graph;
    private static boolean[] checked;

    public static void dfs(int x) {
        checked[x] = true;

        System.out.println(x);

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i).getKey();

            if (checked[y] == false) {
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("총 정점 : ");
        int vertex = sc.nextInt();
        System.out.print("총 간선 : ");
        int edge = sc.nextInt();

        ListGraphSample listGraphSample = new ListGraphSample(vertex, edge);
        graph = listGraphSample.setGraph();

        checked = new boolean[vertex + 1];

        listGraphSample.printGraph(graph);

        dfs(1);

    }
}
