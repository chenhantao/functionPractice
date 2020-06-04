package cht.sort.array;

/**
 * 插入排序
 *
 * @author chenhantao
 * @since 2019/8/29
 */
public class InsertionSort {
    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        if (array.length == 0) {
            System.out.println("数组为空");
            return;
        }

        long start = System.currentTimeMillis();
        // 初始选择第一个元素作为有序区
        for (int i = 1; i < array.length; i++) {
            E insertValue = array[i];

            int j;
            // 取无序区最左边的一个和有序区最右边的做比较
            for (j = i - 1; j >= 0 && (insertValue.compareTo(array[j]) < 0); j--) {
                // 因为上面已经暂存了要插入的值，因此将有序区的元素后移不交换
                array[j + 1] = array[j];
            }
            // 不是很好表达，画个图就知道了
            array[j + 1] = insertValue;
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "ms");
    }
}
