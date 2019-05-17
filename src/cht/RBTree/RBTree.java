package cht.RBTree;

/**
 * 模仿红黑树
 * 1.节点是红色或黑色。
 * 2.根节点是黑色。
 * 3.每个叶子节点都是黑色的空节点（NIL节点）。
 * 4 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
 * 5.从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
 *
 * @author chenhantao
 * @since 2019/5/16
 */
public class RBTree<T extends Comparable<T>> {

    // 根节点
    private RBTNode<T> root;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    /**
     *
     * 对外的插入接口，主要用于赋值key
     * @param key 值
     */
    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);

        System.out.println("新建node节点成功");
        insert(node);
    }

    /**
     * 对红黑树的节点(a)进行左旋转
     *
     * 左旋示意图(对节点a进行左旋)：
     *      pa                              pa
     *     /                               /
     *    a                               b
     *   /  \      --(左旋)-.           / \                #
     *  la   b                          a  ry
     *     /   \                       /  \
     *    lb   rb                     la  lb
     *
     * @param a 左旋的节点
     */
    private void lifeRotate(RBTNode<T> a) {
        // a的右节点
        RBTNode<T> b = a.right;

        // b的左节点变为a的右节点
        a.right = b.left;
        // 如果lb不为空，设a为lb的父节点
        if (b.left != null) {
            b.left.parent = a;
        }

        // 左旋后，a的父节点变为b的父节点
        b.parent = a.parent;

        // a有可能是根节点，因为左旋后，b可能会变成根节点
        if (a.parent == null) {
            this.root = b;
        } else {
            // 变更后，需要更改父节点的子节点信息，即 pa的左右子节点
            if (a.parent.left == a) {
                a.parent.left = b;
            } else {
                a.parent.right = b;
            }
        }

        // a变为b的左节点
        b.left = a;
        // b变为a的父节点
        a.parent = b;
    }

    /**
     * 对红黑树的节点(b)进行右旋转
     *
     * 右旋示意图(对节点b进行左旋)：
     *            pb                               pb
     *           /                                /
     *          b                                a
     *         /  \      --(右旋)-.            /  \                     #
     *        a   rb                           la   b
     *       / \                                   / \                   #
     *      la  ra                                ra  rb
     *
     * @param b 右旋的节点
     */
    private void rightRotate(RBTNode<T> b) {
        // 获取b的左节点a
        RBTNode<T> a = b.left;

        // b的左节点变为a的右节点
        b.left = a.right;
        // ra不为空的话，父节点变为b
        if (a.right != null) {
            a.right.parent = b;
        }

        // 右旋后，b的父节点变为a的父节点
        a.parent = b.parent;

        // b有可能是根节点
        if (b.parent == null) {
            this.root = a;
        } else {
            if (b.parent.left == b) {
                b.parent.left = a;
            } else {
                b.parent.right = a;
            }
        }

        a.right = b;
        b.parent = a;
    }

    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> temp = null;
        RBTNode<T> sign = this.root;

        // 1. 从根节点找起，将红黑树当做二叉查找树，将节点添加到二叉查找树中
        while (sign != null) {
            temp = sign;
            cmp = node.key.compareTo(sign.key);
            // 如果node < root，则取更小的来比较
            if (cmp < 0) {
                sign = sign.left;
            } else {
                sign = sign.right;
            }
        }
        // 对比过后，找到node的位置,将node的设置在某个节点下
        node.parent =  temp;

        // 把node设置为别的节点的子节点
        if (temp != null) {
            cmp = node.key.compareTo(temp.key);
            if (cmp < 0) {
                temp.left = node;
            } else {
                temp.right = node;
            }
        } else {
            this.root = node;
        }

        // 2. 设置节点为红色
        node.color = RED;

        // 3. 修正为二叉查找树
        insertFix(node);
    }

    /**
     * 插入新值后调用，用于重新塑造红黑树
     *
     * @param node 节点
     */
    private void insertFix(RBTNode<T> node) {
        RBTNode<T> parent, gParent;

        // 若父节点存在，且父节点为红色
        while ((parent = parentOf(node)) != null && isRed(parent)) {
            gParent = parentOf(parent);

            // 若 父节点 是祖父节点的左节点
            if (parent == gParent.left) {

            }
        }
    }






    // 一些简单的判空方法和赋值方法
    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }
    private boolean isRed(RBTNode<T> node) {
        return node != null && node.color == RED;
    }
}
