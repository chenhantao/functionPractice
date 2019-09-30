package cht.tree.rbtree;

/**
 * 红黑树测试
 *
 * @author chenhantao
 * @since 2019/5/24
 */
public class RBTreeTest {


    //private static final int[] a = {10, 40, 30, 60, 90, 70, 20, 50, 80};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] a = {11, 3, 20, 21, 44, 80, 311, 32, 1, 500};

        System.out.print("原始数据: ");
        //Arrays.stream(a).forEach(e -> System.out.print(e + " "));
        for (int i : a) {
            System.out.println(i + " ");
        }
        System.out.println();

        RBTree<Integer> tree = new RBTree<>();
        //Arrays.stream(a).forEach(tree::insert);
        for (int i : a) {
            tree.insert(i);
        }
        tree.order();

        tree.remove(3);
        tree.order();

        System.out.println("耗时: " + (System.currentTimeMillis() - start));
    }
}
