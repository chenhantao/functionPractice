package cht.designpattern.creationalpatterns.abstractfactory;

import java.util.Objects;

import cht.designpattern.creationalpatterns.abstractfactory.factory.AbstractFactory;
import cht.designpattern.creationalpatterns.abstractfactory.factory.ColorFactory;
import cht.designpattern.creationalpatterns.abstractfactory.factory.ShapeFactory;
import cht.designpattern.creationalpatterns.basic.enums.TypeEnum;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        TypeEnum typeByType = TypeEnum.getTypeByType(type);
        if (Objects.isNull(typeByType)) {
            throw new RuntimeException("Can not find ANY factory !!!");
        }
        switch (typeByType) {
            case SHAPE:
                return new ShapeFactory();
            case COLOR:
                return new ColorFactory();
            default:
        }
        throw new RuntimeException("Can not find ANY factory !!!");
    }
}
