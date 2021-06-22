package cht.designpattern.creationalpatterns.factory;

import java.util.Objects;

import cht.designpattern.creationalpatterns.basic.common.Shape;
import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;
import cht.designpattern.creationalpatterns.basic.model.shape.Circle;
import cht.designpattern.creationalpatterns.basic.model.shape.Rectangle;
import cht.designpattern.creationalpatterns.basic.model.shape.Square;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/21
 */
public class ShapeFactory {

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
