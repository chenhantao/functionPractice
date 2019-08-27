package cht.sort.array;

/**
 * 用数组实现的，写起来会方便一点
 *
 * @author chenhantao
 * @since 2019/8/27
 */
public class BubbleSort {
    /**
     * 最简单的冒泡排序，即无脑双循环遍历
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void bubbleSortA(E[] array) {
        long start = System.currentTimeMillis();
        if (array.length == 0) {
            return;
        }
        E temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "s");
    }


    /**
     * 稍微改进过的冒泡排序，若某次没交换，即以后的遍历都是有序的，可以直接结束
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void bubbleSortB(E[] array) {
        long start = System.currentTimeMillis();

        if (array.length == 0) {
            return;
        }
        E temp;
        for (int i = 0; i < array.length; i++) {
            boolean isChanged = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isChanged = true;
                }
            }
            // 没有变化说明都是有序的
            if (!isChanged) {
                break;
            }
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "s");
    }
}
