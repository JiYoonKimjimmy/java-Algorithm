package algorithm.sort;

import java.util.List;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class DfsSample_01 {

    private static List<List<Integer>> graph;
    private static boolean[] checked;

    public static void dfs(int x) {
        checked[x] = true;

        System.out.println(x);

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);

            if (checked[y] == false) {
                dfs(y);
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

        for (int i = 0; i < graph.size(); i++) {
            List<Integer> item = graph.get(i);
            System.out.print(i + " : ");
            for (int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + ", ");
            }
            System.out.println();
        }

        System.out.println("---------------------");

        dfs(1);

    }
}
