package cht.sort.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 本来想一个排序一个类，很麻烦，就整合到一起吧
 *
 * @author chenhantao
 * @since 2019/8/27
 */
public class BubbleSort {

    /**
     * 最最简单的冒泡排序
     */
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        long start = System.currentTimeMillis();

        T temp;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            test.add((int) (Math.random() * 900 + 100));
        }
        BubbleSort.bubbleSort(test);

        System.out.println(test);
    }
}
