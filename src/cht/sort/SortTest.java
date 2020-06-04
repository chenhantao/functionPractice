package cht.sort;

import java.util.Arrays;

import cht.sort.array.ShellSort;

/**
 * 随便测试啦
 *
 * @author chenhantao
 * @since 2019/8/27
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 11, 32, 13, 51, 12, 53, 32, 141, 1111, 123, 15, 133, 121, 8, 21, 22, 1233, 23456,
                1232, 55, 51, 76, 531, 889, 12335, 22333, 33, 64, 88, 345, 980};
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

//        InsertionSort.insertionSort(b);
//        System.out.println(Arrays.toString(b));

        String[] test = new String[]{"ad", "asdsa", "scve", "ascfq", "sssss", "apsdnmkl"};
        //BubbleSort.cockTailSortUpdate(test);
        ShellSort.shellSort(b);
        //QuickSort.quickSort(b);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(test));
    }


}
