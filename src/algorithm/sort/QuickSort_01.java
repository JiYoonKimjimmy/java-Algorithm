package algorithm.sort;

/**
 * @author Jim, Kim
 * @since 2019-04-26
 */
public class QuickSort_01 {

    /**
     * Quick Sort
     * @param data
     * @param start
     * @param end
     */
    public static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }

        /**
         * key : 피벗
         * i : 오른쪽으로 이동(피벗보다 큰 수)
         * j : 왼쪽으로 이동(피벗보다 작은 수
         */
        int key = start;
        int i = start + 1, j = end, temp;

        while (i <= j) {
            while (i <= end && data[i] <= data[key]) {
                // (-->) 오른쪽으로 이동하면서, 키 값보다 큰 값을 만날 떄까지
                i++;
            }

            while (j > start && data[j] >= data[key]) {
                // (<--) 왼쪽으로 이동하면서, 키 값보다 작은 값을 만날 떄까지
                j--;
            }

            if (i > j) {
                // 검색 지점들이 교차하는 순간, 검색된 작은 수와 피벗값을 교체
                temp = data[j];
                data[j] = data[key];
                data[key] = temp;
            } else  {
                // 교차가 아닐 땐, 검색된 큰 수와 작은 수를 교체
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        // 정렬이 된 후, 위치를 바꾼 큰 수를 피벗으로
        quickSort(data, start, j - 1);  // 왼쪽을 한번 더 퀵 정렬 하고,
        quickSort(data, j + 1, end);    // 오른쪽을 한번 더 퀵 정렬 한다.

    }

    public static void main(String[] args) {
        int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

        quickSort(data, 0, data.length - 1);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
