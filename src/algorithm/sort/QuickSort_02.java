package algorithm.sort;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jim, Kim
 * @since 2019-05-02
 */
public class QuickSort_02 {
    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) return list;

        int pivot = list.get(list.size() / 2);

        List<Integer> lesserArr = new LinkedList<>();
        List<Integer> equalArr = new LinkedList<>();
        List<Integer> greaterArr = new LinkedList<>();

        for (int num : list) {
            if (num < pivot) lesserArr.add(num);
            else if (num == pivot) equalArr.add(num);
            else greaterArr.add(num);
        }

        return Stream.of(quickSort(lesserArr), equalArr, quickSort(greaterArr))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Integer> input = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            input.add(sc.nextInt());
        }

        input = quickSort(input);

        for (int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i));
        }
    }
}