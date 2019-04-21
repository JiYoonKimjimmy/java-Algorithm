package algorithm.sort;

/**
 * @author Jim, Kim
 * @since 2019-04-21
 */
public class BubbleSort_01 {
    public static void main(String[] args) {
        int[] sample = {1, 9, 5, 8, 7, 6, 4, 3, 2, 10};
        int temp = 0;

        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < (sample.length - 1) - i; j++) {
                if (sample[j] > sample[j + 1]) {
                    temp = sample[j];
                    sample[j] = sample[j + 1];
                    sample[j + 1] = temp;
                }

                System.out.print(j + " : ");
                for (int k = 0; k < sample.length; k++) {
                    System.out.print(sample[k]  + "  ");
                }
                System.out.println();
            }
        }

        System.out.print("result : ");
        for (int i = 0; i < sample.length; i++) {
            System.out.print(sample[i]  + "  ");
        }
    }
}