package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-04
 */
public class MergeSort_02 {

    public static int[] mergeSort(int[] input) {
        if (input.length < 2) return input;

        int middle = input.length / 2;

        /**
         * Arrays.copyOfRange() 함수에 대해서
         * - 전달 array 의 정해진 범위까지 새로운 array 를 copy
         * - 즉, low_arr 는 왼쪽을 절반씩 줄여가며 정렬을 하고,
         * - high_arr 는 오른쪽을 절반씩 줄여가며 정렬을 한다.
         */
        int[] low_arr = mergeSort(Arrays.copyOfRange(input, 0, middle));
        int[] high_arr = mergeSort(Arrays.copyOfRange(input, middle, input.length));

        int[] merge_arr = new int[input.length];

        int m = 0, low = 0, high = 0;

        while (low < low_arr.length && high < high_arr.length) {
            if (low_arr[low] < high_arr[high]) {
                merge_arr[m++] = low_arr[low++];
            } else {
                merge_arr[m++] = high_arr[high++];
            }
        }

        while (low < low_arr.length) {
            merge_arr[m++] = low_arr[low++];
        }

        while (high < high_arr.length) {
            merge_arr[m++] = high_arr[high++];
        }

        return merge_arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] input = new int[size];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        input = mergeSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}