package algorithm.sort;

import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-04
 */
public class MergeSort_01 {
    public static int[] sorted;

    public static void merge(int[] input, int m, int middle, int n) {
        // m: 시작점 |  middle: 중간점 | n: 끝점
        int i = m;
        int j = middle + 1;
        int k = m;

        while (i <= middle && j <= n) {
            if (input[i] <= input[j]) {
                sorted[k] = input[i];
                i++;
            } else {
                sorted[k] = input[j];
                j++;
            }

            k++;
        }

        // 정렬된 배열 외의 나머지들은 그대로 sorted 배열에 담기
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = input[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = input[t];
                k++;
            }
        }

        for (int t = m; t <= n; t++) {
            input[t] = sorted[t];
        }
    }

    public static void mergeSort(int[] input, int m, int n) {
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(input, m, middle);
            mergeSort(input, middle + 1, n);
            merge(input, m, middle, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] input = new int[size];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        sorted = new int[input.length];

        mergeSort(input, 0, input.length - 1);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
