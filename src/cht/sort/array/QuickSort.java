package cht.sort.array;

/**
 * 快速排序
 *
 * @author chenhantao
 * @since 2019/8/28
 */
public class QuickSort {
    /**
     * 快速排序算法
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void quickSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void quickSort(E[] array, int start, int end) {
        if (start >= end) {
            return;
        }


    }

    private static <E extends Comparable<E>> int partition(E[] array, int start, int end) {
        // 取第一个为基准
        E pivot = array[start];
        int left = start;
        int right = end;

        int index = start;

    }
}
