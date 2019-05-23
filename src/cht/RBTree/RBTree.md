# 红黑树 Java实现

### 红黑树基本概念
> 基于此文来描述 [漫画:什么是红黑树](https://mp.weixin.qq.com/s/jz1ajDUygZ7sXLQFHyfjWA)
>> 因为懒得放图，所以只说明一些关键原理
#### 先了解二叉查找树  
二叉查找树（BST）具备什么特性呢？

> 1. 左子树上所有结点的值均小于或等于它的根结点的值。  
> 2. 右子树上所有结点的值均大于或等于它的根结点的值。  
> 3. 左、右子树也分别为二叉排序树。 

**但是多次插入新节点后可能导致不平衡，因此需要红黑树**

> 红黑树 (Red Black Tree) 是一种自平衡的二叉查找树，除了符合二叉查找树的基本特征外，
它还具有下列的附加特性：
>> 1. 节点是红色或黑色。  
>> 2. 根节点是黑色。  
>> 3. 每个叶子节点都是黑色的空节点（NIL节点）。  
>> 4. 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)  
>> 5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

### 一些关键概念
左旋转：逆时针旋转红黑树的两个节点，使得父节点被自己的右孩子取代，而自己成为自己的左孩子。
```$代码大致如此
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
```

右旋转：顺时针旋转红黑树的两个节点，使得父节点被自己的左孩子取代，而自己成为自己的右孩子。
```$代码也是大致如此
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
```

Java中TreeMap和TreeSet的底层是红黑树，1.8里，HashMap也用到了红黑树，根据源码，大于8时，才会采用红黑树，但是代码可读性略差，不是很好懂，因此借鉴了网上博客的内容