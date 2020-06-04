package cht.tree.rbtree;

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
     * 对红黑树的节点(a)进行左旋转
     *
     * 左旋示意图(对节点a进行左旋)：
     *      pa                              pa
     *     /                               /
     *    a                               b
     *   /  \      --(左旋)-.           / \                #
     *  la   b                          a  rb
     *     /   \                       /  \
     *    lb   rb                     la  lb
     *
     * @param a 左旋的节点
     */
    private void leftRotate(RBTNode<T> a) {
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
                RBTNode<T> uncle = gParent.right;
                // 1: 叔节点为红色
                if (isRed(uncle)) {
                    setBlack(parent);
                    setRed(gParent);
                    setBlack(uncle);
                    node = gParent;
                    continue;
                }

                // 2. 叔节点为黑色，且当前节点为右节点
                if (parent.right == node) {
                    RBTNode<T> temp;
                    leftRotate(parent);
                    temp = parent;
                    parent = node;
                    node = temp;
                }

                // 3. 叔节点是黑色，且当前节点是左节点
                setBlack(parent);
                setRed(gParent);
                rightRotate(gParent);
            } else {
                // 父节点为祖父节点的右节点
                RBTNode<T> uncle = gParent.left;
                // 1.  叔节点为红色
                if (isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gParent);
                    node = gParent;
                    continue;
                }

                // 2. 叔节点为黑色，且当前节点为左节点
                if (parent.left == node) {
                    RBTNode<T> temp;
                    rightRotate(parent);
                    temp = parent;
                    parent = node;
                    node = temp;
                }

                // 3. 叔节点是黑色, 且当前节点为右节点
                setBlack(parent);
                setRed(gParent);
                leftRotate(gParent);

            }
        }

        setBlack(this.root);
    }

    /**
     * 删除节点，并返回
     * @param node 待删除的节点
     */
    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;

        // 被删除节点的左右子节点都不为空
        if (node.left != null && node.right != null) {
            // 用来替代被删除的节点，用该节点代替被删除的节点，然后再删除要删除的节点
            RBTNode<T> replace;

            // 获取后继节点
            replace = node.right;
            while (replace.left != null) {
                replace = replace.left;
            }

            // node节点不是根节点，即没有父节点的节点
            if (parentOf(node) != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                this.root = replace;
            }

            // child是后继节点的右子节点，后继节点不存在左子节点
            child = replace.right;
            parent = parentOf(replace);

            // 保存取代节点的颜色
            color = replace.color;

            // 被删除的节点是后继节点的父节点
            if (parent == node) {
                parent = replace;
            } else {
                // child不为空
                if (child != null) {
                    child.parent = parent;
                }
                parent.left = child;

                replace.right = node.right;
                node.right.parent = replace;
            }

            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;

            if (color == BLACK) {
                removeFix(child, parent);
            }
            //node = null;
            return;

        }

        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        // 保存取代节点的颜色
        color = node.color;

        if (child != null) {
            child.parent = parent;
        }

        // node不是根节点
        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            this.root = child;
        }

        if (color == BLACK) {
            removeFix(child, parent);
        }
        //node = null;
    }

    /**
     * 红黑树修正函数，删除节点后调用
     * @param node 带修正的点
     * @param parent 父节点
     */
    private void removeFix(RBTNode<T> node, RBTNode<T> parent) {
        // node 的兄弟节点
        RBTNode<T> otherNode;

        while ((node == null || isBlack(node)) && (node != this.root)) {
            if (parent.left == node) {
                otherNode = parent.right;
                if (isRed(otherNode)) {
                    // case 1. node的兄弟节点是红色
                    setBlack(otherNode);
                    setRed(parent);
                    leftRotate(parent);
                    otherNode = parent.right;
                }

                if ((otherNode.left == null || isBlack(otherNode.left)) && (otherNode.right == null || isBlack(otherNode.right))) {
                    // case 2. node的兄弟节点是黑色，且兄弟节点的两个子节点也是黑色
                    setRed(otherNode);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (otherNode.right == null || isBlack(otherNode.right)) {
                        // case 3. node的兄弟节点是黑色，但是兄弟节点的左节点是红色，右节点是黑色
                        setBlack(otherNode.left);
                        setRed(otherNode);
                        rightRotate(otherNode);
                        otherNode = parent.right;
                    }
                    // case 4. node的兄弟节点是黑色，并且兄弟节点的右节点是红色，左节点任意颜色
                    otherNode.color = parent.color;
                    setBlack(parent);
                    setBlack(otherNode.right);
                    leftRotate(parent);
                    node = this.root;
                    break;
                }
            } else {
                otherNode = parent.left;

                if (isRed(otherNode)) {
                    // case 1. node的兄弟节点是红色
                    setBlack(otherNode);
                    setRed(parent);
                    rightRotate(parent);
                    otherNode = parent.left;
                }

                if ((otherNode.left == null || isBlack(otherNode.left)) && (otherNode.right == null || isBlack(otherNode.right))) {
                    // case 2. node的兄弟节点是黑色，且兄弟节点的两个子节点也都是黑色
                    setRed(otherNode);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (otherNode.left == null || isBlack(otherNode.left)) {
                        // case 3. node的兄弟节点是黑色，且兄弟节点的左节点是红色，右节点是黑色
                        setBlack(otherNode.right);
                        setRed(otherNode);
                        leftRotate(otherNode);
                        otherNode = parent.left;
                    }
                    // case 4. node的兄弟节点是黑的，且兄弟节点的右节点是红色，左节点任意
                    otherNode.color = parent.color;
                    setBlack(parent);
                    setBlack(otherNode.left);
                    rightRotate(parent);
                    node = this.root;
                    break;
                }
            }
        }

        if (node != null) {
            setBlack(node);
        }


    }

    /**
     *
     * 对外的插入接口，主要用于赋值key
     * @param key 值
     */
    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, RED, null, null, null);

        //System.out.println("新建node节点成功");
        insert(node);
    }

    /**
     * 根据值来删除节点
     * @param key 值
     */
    public void remove(T key) {
        RBTNode<T> node = search(key);
        if (node != null) {
            remove(node);
        }
    }

    /**
     * 查询接口，通过值来查找节点
     * @param key 值
     * @return key对应的节点
     */
    public RBTNode<T> search(T key) {
        return search(this.root, key);
    }

    public RBTNode<T> minNode(RBTNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public RBTNode<T> maxNode(RBTNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }
    private void preOrder(RBTNode<T> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }
    private void inOrder(RBTNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(RBTNode<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public void order() {
        System.out.println("前序遍历: ");
        this.preOrder();
        System.out.println();

        System.out.println("中序遍历: ");
        this.inOrder();
        System.out.println();

        System.out.println("后序遍历: ");
        this.postOrder();
        System.out.println();
    }

    // 一些简单的判空方法和赋值方法
    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }
    private boolean isRed(RBTNode<T> node) {
        return node != null && node.color == RED;
    }
    private boolean isBlack(RBTNode<T> node) {
        return node != null && node.color == BLACK;
    }
    private void setRed(RBTNode node) {
        if (node != null) {
            node.color = RED;
        }
    }
    private void setBlack(RBTNode node) {
        if (node != null) {
            node.color = BLACK;
        }
    }
    private RBTNode<T> search(RBTNode<T> node, T key) {
        if (node == null) {
            return null;
        }

        int temp = key.compareTo(node.key);
        if (temp < 0) {
            return search(node.left, key);
        } else if (temp > 0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }
}
