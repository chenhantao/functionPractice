package cht.sort;

import java.util.Arrays;

import cht.sort.array.BubbleSort;

/**
 * 随便测试啦
 *
 * @author chenhantao
 * @since 2019/8/27
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 11, 32, 13, 51, 12, 53};

        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        BubbleSort.cockTailSortUpdate(b);
        System.out.println(Arrays.toString(b));
    }


}
