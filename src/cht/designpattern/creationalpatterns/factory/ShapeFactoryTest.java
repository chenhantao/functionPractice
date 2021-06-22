package cht.designpattern.creationalpatterns.factory;

import cht.designpattern.creationalpatterns.basic.common.Shape;
import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/21
 */
public class ShapeFactoryTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(ShapeTypeEnum.CIRCLE.getType());
        shape.draw();

        Shape shape1 = shapeFactory.getShape(ShapeTypeEnum.SQUARE.getType());
        shape1.draw();

        Shape shape2 = shapeFactory.getShape(ShapeTypeEnum.RECTANGLE.getType());
        shape2.draw();
    }
}
