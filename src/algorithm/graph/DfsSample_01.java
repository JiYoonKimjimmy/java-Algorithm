package algorithm.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-22
 */
public class DfsSample_01 {
    private static List<String> printList;
    private static List<List<Pair<Integer, Integer>>> graph;
    private static boolean[] checked;

    /**
     * DFS(Deep First Search) - 깊이 우선 탐색
     * root node 로부터 시작하여 다음 branch 로 넘어가기 전에 해당 branch 를 완벽하게 탐색하는 방법이다.
     * 즉, 넓게(wide) 가 아닌, 깊게(deep) 탐색하는 알고리즘이다.
     * ex) 미로를 탐색할 경우, 한 방향으로 계속 탐색하다가 더이상 갈 수 없을 때,
     * 다시 가까운 갈림길로 돌아와서 다른 방향으로 탐색을 이어가는 방법으로 적합하다.
     */
    public static void dfs(int x) {
        checked[x] = true;

        printList.add(String.valueOf(x));

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i).getKey();

            if (checked[y] == false) {
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printList = new LinkedList<>();

        ListGraphSample listGraphSample = new ListGraphSample();
        graph = listGraphSample.getGraph();

        int vertex = listGraphSample.getVertex();
        checked = new boolean[vertex + 1];

        System.out.print("DFS 접근 노드 : ");
        int start = sc.nextInt();
        dfs(start);

        System.out.println("result of DFS : " + String.join(" -> ", printList));

    }
}
