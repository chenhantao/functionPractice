package cht.anything;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2019/5/16
 */
public class Test {
    public static void main(String[] args) {
        SimpleList<Integer> test = new SimpleList<>();
        for (int i = 0; i < 11; i++) {
            test.add(i);
            System.out.println(test.get(i));
        }
        System.out.println(test.size());

    }
}
