package cht.designpattern.creationalpatterns.abstractfactory.factory;

import cht.designpattern.creationalpatterns.basic.common.Color;
import cht.designpattern.creationalpatterns.basic.common.Shape;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String colorType);

    public abstract Shape getShape(String shapeType);
}
