package cht.designpattern.creationalpatterns.abstractfactory.factory;

import java.util.Objects;

import cht.designpattern.creationalpatterns.basic.common.Color;
import cht.designpattern.creationalpatterns.basic.common.Shape;
import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;
import cht.designpattern.creationalpatterns.basic.model.shape.Circle;
import cht.designpattern.creationalpatterns.basic.model.shape.Rectangle;
import cht.designpattern.creationalpatterns.basic.model.shape.Square;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        ShapeTypeEnum shapeByType = ShapeTypeEnum.getShapeByType(shapeType);
        if (Objects.isNull(shapeByType)) {
            return null;
        }
        switch (shapeByType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                return null;
        }
    }
}
