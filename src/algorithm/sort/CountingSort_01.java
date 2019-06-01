package algorithm.sort;

import java.util.Scanner;

public class CountingSort_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] input = new int[size];
        int[] sorted = new int[size];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
            sorted[input[i] - 1]++;
        }

        for (int i = 0; i < sorted.length; i++) {
            while (sorted[i] != 0) {
                System.out.print((i + 1) + " ");
                sorted[i]--;
            }
        }
    }
}