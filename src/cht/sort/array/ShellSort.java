package cht.sort.array;

/**
 * shell排序
 *
 * @author chenhantao
 * @since 2019/9/10
 */
public class ShellSort {
    public static <E extends Comparable<E>> void shellSort(E[] array) {
        if (array.length == 0) {
            System.out.println("数组为空");
            return;
        }

        long start = System.currentTimeMillis();

        int sign = array.length;
        while (sign > 1) {
            sign = sign / 2;
            for (int i = 0; i < sign; i++) {
                for (int j = i + sign; j < array.length; j = j + sign) {
                    E temp = array[j];
                    int k;
                    for (k = j - sign; k >= 0 && array[k].compareTo(temp) > 0; k = k - sign) {
                        array[k + sign] = array[k];
                    }
                    array[k + sign] = temp;
                }
            }
        }

        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "s");
    }
}
