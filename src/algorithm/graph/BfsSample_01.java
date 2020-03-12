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

    /**
     * BFS(Breadth First Search) - 너비 우선 탐색
     * root node 로부터 시작하여 인접 node 들을 먼저 탐색하는 방법이다.
     * 즉, 깊게(deep) 탐색하는 방법이 아닌, 넓게(wide) 탐색하는 알고리즘이다.
     * ex) 친구 관계를 탐색할 경우, bfs 알고리즘이 사용해야하는 이유 :
     * 특정 인물의 모든 친구 관계를 파악하기 위해서는,
     * 특정 인물과 직접적으로 연결된 친구들부터 먼저 탐색하는 것이 더 적합하다.
     */
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
        Scanner scanner = new Scanner(System.in);

        ListGraphSample listGraphSample = new ListGraphSample();
        graph = listGraphSample.getGraph();

        int vertex = listGraphSample.getVertex();
        checked = new boolean[vertex + 1];

        System.out.print("BFS 접근 노드 : ");
        int start = scanner.nextInt();
        bfs(start);

        System.out.println("result of BFS : " + String.join(" -> ", printList));
    }
}
