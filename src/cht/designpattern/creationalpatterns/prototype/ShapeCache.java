package cht.designpattern.creationalpatterns.prototype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cht.designpattern.creationalpatterns.prototype.abstracts.Circle;
import cht.designpattern.creationalpatterns.prototype.abstracts.Rectangle;
import cht.designpattern.creationalpatterns.prototype.abstracts.Shape;
import cht.designpattern.creationalpatterns.prototype.abstracts.Square;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class ShapeCache {

    private static final Map<Integer, Shape> SHAPE_MAP = new ConcurrentHashMap<>();

    static {
        Circle circle = new Circle();
        circle.setId(1);
        SHAPE_MAP.put(1, circle);

        Square square = new Square();
        square.setId(2);
        SHAPE_MAP.put(2, square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(3);
        SHAPE_MAP.put(3, rectangle);
    }

    public static Shape getShape(Integer shapeId) {
        Shape shape = SHAPE_MAP.get(shapeId);
        return (Shape)shape.clone();
    }

}
