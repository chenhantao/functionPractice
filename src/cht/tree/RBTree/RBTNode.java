package cht.tree.RBTree;

/**
 * 红黑树节点实现类
 *
 * @author chenhantao
 * @since 2019/5/17
 */
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

    public boolean isColor() {
        return color;
    }

    public RBTNode<T> getLeft() {
        return left;
    }

    public RBTNode<T> getRight() {
        return right;
    }

    public RBTNode<T> getParent() {
        return parent;
    }
}