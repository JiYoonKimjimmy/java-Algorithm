package algorithm.sort;

import java.util.List;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class BfsSample_01 {

    public static void bfs() {

    }

    public static void graph() {

    }

    public static void main(String[] args) {
        GraphSample_01 Graph = new GraphSample_01(4, 4);

        List<List<Integer>> graph = Graph.setGraph();

        for (int i = 0; i < graph.size(); i++) {
            List<Integer> item = graph.get(i);
            for (int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + " ");
            }
            System.out.println();
        }
    }
}
