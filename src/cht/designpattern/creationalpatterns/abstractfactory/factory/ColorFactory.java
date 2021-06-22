package cht.designpattern.creationalpatterns.abstractfactory.factory;

import java.util.Objects;

import cht.designpattern.creationalpatterns.basic.common.Color;
import cht.designpattern.creationalpatterns.basic.common.Shape;
import cht.designpattern.creationalpatterns.basic.enums.ColorTypeEnum;
import cht.designpattern.creationalpatterns.basic.model.color.Blue;
import cht.designpattern.creationalpatterns.basic.model.color.Green;
import cht.designpattern.creationalpatterns.basic.model.color.Red;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        ColorTypeEnum colorByType = ColorTypeEnum.getColorByType(colorType);
        if (Objects.isNull(colorByType)) {
            return null;
        }
        switch (colorByType) {
            case BLUE:
                return new Blue();
            case GREEN:
                return new Green();
            case RED:
                return new Red();
            default:
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
