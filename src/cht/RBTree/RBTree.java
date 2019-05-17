package cht.RBTree;

/**
 * 模仿红黑树
 *
 * @author chenhantao
 * @since 2019/5/16
 */
public class RBTree<T extends Comparable<T>> {

    // 根节点
    private RBTNode<T> root;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }
    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      pa                              pa
     *     /                               /
     *    a                               b
     *   /  \      --(左旋)-.           / \                #
     *  la   b                          a  ry
     *     /   \                       /  \
     *    lb   rb                     la  lb
     *
     *
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

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            pb                               pb
     *           /                                /
     *          b                                a
     *         /  \      --(右旋)-.            /  \                     #
     *        a   rb                           la   b
     *       / \                                   / \                   #
     *      la  ra                                ra  rb
     *
     */
    private void rightRotate(RBTNode<T> b) {
        // 获取b的左节点a
        RBTNode<T> a = b.left;

        // b的左节点变为a的右节点

    }

}
