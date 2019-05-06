package algorithm.sort;

/**
 * @author Jim, Kim
 * @since 2019-05-06
 */
public class HeapSort_01 {
    private static final int[] input = {7, 6, 5, 8, 3, 5, 9, 1, 6};

    public static void generateHeapInit () {
        for (int i = 1; i < input.length; i++) {
            int c = i;

            do {
                int root = (c - 1) / 2;
                if (input[root] < input[c]) {
                    int temp = input[root];
                    input[root] = input[c];
                    input[c] = temp;
                }

                c = root;
            } while (c != 0);
        }
    }

    public static void heapSort() {
        for (int i = input.length - 1; i >= 0; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            int root = 0, c = 1;

            do {
                c = 2 * root + 1;   // 자식 노드

                if (c < i -1 && input[c] < input[c + 1]) {
                    // 두번째 자식 노드가 더 클 경우
                    c++;
                }

                if (c < i && input[root] < input[c]) {
                    temp = input[root];
                    input[root] = input[c];
                    input[c] = temp;
                }

                root = c;
            } while (c < i);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        // 힙 생성
        generateHeapInit();

        heapSort();

        System.out.println();

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
