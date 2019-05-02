package algorithm.sort;

import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-05-02
 */
public class SelectionSort_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] input = new int[size];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        int temp, index = 0;
        for (int i = 0; i < input.length; i++) {
            int min = 1001;
            for (int j = i; j < input.length; j++) {
                if (min > input[j]) {
                    min = input[j];
                    index = j;
                }
            }

            temp = input[i];
            input[i] = input[index];
            input[index] = temp;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
