package cht.designpattern.creationalpatterns.abstractfactory;

import cht.designpattern.creationalpatterns.abstractfactory.factory.AbstractFactory;
import cht.designpattern.creationalpatterns.basic.common.Shape;
import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;
import cht.designpattern.creationalpatterns.basic.enums.TypeEnum;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(TypeEnum.SHAPE.getType());
        Shape shape = shapeFactory.getShape(ShapeTypeEnum.CIRCLE.getType());
        shape.draw();

    }
}
