package cht.sort.array;

/**
 * 选择排序，很简单
 *
 * @author chenhantao
 * @since 2019/8/28
 */
public class SelectionSort {
    public static <E extends Comparable<E>> void selectionSort(E[] array) {
        if (array.length == 0) {
            System.out.println("数组为空");
            return;
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            // 记录要插入的索引位置
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[i].compareTo(array[j]) < 0 ? i : j;
            }
            E temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "s");
    }
}
