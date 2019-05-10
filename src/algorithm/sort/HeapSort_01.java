package algorithm.sort;

/**
 * @author Jim, Kim
 * @since 2019-05-06
 */
public class HeapSort_01 {
    private static final int[] input = {7, 6, 5, 8, 3, 5, 9, 1, 6};

    public static void generateHeapInit () {
        for (int i = 1; i < input.length; i++) {
            int child = i;

            do {
                int root = (child - 1) / 2;     // 현재 배열 위치의 root index 찾기

                if (input[root] < input[child]) {
                    // root가 child 보다 작은 경우, swap
                    int temp = input[root];
                    input[root] = input[child];
                    input[child] = temp;
                }

                child = root;
            } while (child != 0);
        }
    }

    public static void heapSort() {
        for (int i = input.length - 1; i >= 0; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            int root = 0, child = 1;

            do {
                child = 2 * root + 1;   // 자식 노드

                if (child < i -1 && input[child] < input[child + 1]) {
                    // 두번째 자식 노드가 더 클 경우
                    child++;
                }

                if (child < i && input[root] < input[child]) {
                    temp = input[root];
                    input[root] = input[child];
                    input[child] = temp;
                }

                root = child;
            } while (child < i);

        }
    }

    public static void main(String[] args) {
        // 힙 생성
        generateHeapInit();

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        heapSort();

        System.out.println();

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
