package cht.sort;

import java.util.Arrays;
import java.util.Random;

import cht.sort.array.BubbleSort;

/**
 * 随便测试啦
 *
 * @author chenhantao
 * @since 2019/8/27
 */
public class SortTest {
    private static Random random = new Random();


    public static void main(String[] args) {
        bubbleTest();
    }

    public static void bubbleTest() {
        Integer[] integers = new Integer[100];
        for (int i = 0; i < 100; i++) {
            integers[i] = random.nextInt(1000);
        }
        System.out.println("排序前: " + Arrays.toString(integers));
        BubbleSort.bubbleSortBase(integers);
        System.out.println("排序后: " + Arrays.toString(integers));
    }
}
