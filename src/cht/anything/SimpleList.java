package cht.anything;

/**
 * 偶然看到的文章，实现一个最简单的list
 *
 * @author chenhantao
 * @since 2019/8/21
 */
public class SimpleList<T> {
    private Object[] elementData;
    private int size = 0;

    public int size() {
        return size;
    }

    public SimpleList() {
        elementData = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T e) {
        if (size >= elementData.length) {
            Object[] temp = new Object[(elementData.length * 2)];
            for (int i = 0; i < elementData.length; i++) {
                Object elementDatum = elementData[i];
                temp[i] = elementDatum;
            }
            elementData = temp;

            elementData[size++] = e;
            return true;
        } else {
            elementData[size++] = e;
            return true;
        }
    }

    public boolean remove(Object o) {

        return false;
    }

    public T get(int index) {
        return (T) elementData[index];
    }
}
