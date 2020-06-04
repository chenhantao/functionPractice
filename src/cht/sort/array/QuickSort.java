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

        int pivotIndex = partition(array, start, end);

        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int start, int end) {
        // 取第一个为基准
        E pivot = array[start];
        int left = start;
        int right = end;

        int index = start;

        while (left != right) {
            while (left < right && array[right].compareTo(pivot) > 0) {
                right--;
            }

            while (left < right && array[left].compareTo(pivot) <= 0) {
                left++;
            }

            if (left < right) {
                E temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // 交换基准
        E temp = array[left];
        array[left] = array[start];
        array[start] = temp;

        return left;
    }
}
