package algorithm.sort;

/**
 * @author Jim, Kim
 * @since 2019-04-14
 */
public class SelectionSort_01 {
    public static void main(String[] args) {
        int[] sample = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int temp, index = 0;

        for (int i = 0; i < sample.length; i++) {
            int min = 99;
            for (int j = i; j < sample.length; j++) {
                if (min > sample[j]) {
                    min = sample[j];
                    index = j;
                }
            }
            temp = sample[i];
            sample[i] = sample[index];
            sample[index] = temp;

            System.out.print(i + " : ");
            for (int j = 0; j < sample.length; j++) {
                System.out.print(sample[j]  + "  ");
            }
            System.out.println();
        }

        System.out.print("result : ");
        for (int i = 0; i < sample.length; i++) {
            System.out.print(sample[i]  + "  ");
        }
    }
}