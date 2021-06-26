package cht.anything;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/27
 */
public class Power {

    public static void main(String[] args) {
        power(2, 1000);
    }

    public static void power(int base, int power) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < power; i++) {
            if (result.isEmpty()) {
                result.add(base);
            } else {
                int temp = 0;
                for (int j = 0; j < result.size(); j++) {
                    int num = result.get(j) * base + temp;
                    temp = num / 10;
                    int setValue = num % 10;
                    result.set(j, setValue);
                }
                if (temp > 0) {
                    result.add(temp);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            stringBuilder.append(result.get(i));
        }
        System.out.println("结果是： " + stringBuilder);
    }
}
