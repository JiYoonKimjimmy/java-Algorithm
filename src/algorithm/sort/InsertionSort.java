package algorithm.sort;

/**
 * @author Jim, Kim
 * @since 2019-04-21
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] sample = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int temp = 0;

        for (int i = 0; i < sample.length - 1; i++) {
            int j = i;
            while (j >= 0 && sample[j] > sample[j + 1]) {
                temp = sample[j];
                sample[j] = sample[j + 1];
                sample[j + 1] = temp;
                j--;
            }

            System.out.print(j + " : ");
            for (int k = 0; k < sample.length; k++) {
                System.out.print(sample[k]  + "  ");
            }
            System.out.println();
        }

        System.out.print("result : ");
        for (int i = 0; i < sample.length; i++) {
            System.out.print(sample[i]  + "  ");
        }
    }
}
