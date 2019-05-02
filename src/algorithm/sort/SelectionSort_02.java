package algorithm.sort;

import java.util.Scanner;

/**
 * @author Jim, Kim
 * @since 2019-04-29
 */
public class SelectionSort_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input =  new int[3];
        int temp, index = 0;

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        for (int i = 0; i < input.length; i++) {
            int min = 1000001;

            for (int j = i; j < input.length; j++) {
                if (input[j] < min) {
                    min = input[j];
                    index = j;
                }
            }

            temp = input[i];
            input[i] = input[index];
            input[index] = temp;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
