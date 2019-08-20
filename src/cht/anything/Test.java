package cht.anything;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2019/5/16
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(2);

        a.retainAll(b);

        System.out.println(a);
    }
}
