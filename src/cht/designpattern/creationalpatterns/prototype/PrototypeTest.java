package cht.designpattern.creationalpatterns.prototype;

import cht.designpattern.creationalpatterns.prototype.abstracts.Shape;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class PrototypeTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Shape shape = ShapeCache.getShape(i + 1);
            System.out.println("Shape :" + shape.getType());
        }
    }
}
