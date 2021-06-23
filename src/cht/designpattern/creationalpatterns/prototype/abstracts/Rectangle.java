package cht.designpattern.creationalpatterns.prototype.abstracts;

import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = ShapeTypeEnum.RECTANGLE.getType();
    }

    @Override
    public void draw() {
        System.out.println("this is Rectangle::draw");

    }
}
