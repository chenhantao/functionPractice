package cht.designpattern.creationalpatterns.prototype.abstracts;

import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class Circle extends Shape {

    public Circle() {
        type = ShapeTypeEnum.CIRCLE.getType();
    }

    @Override
    public void draw() {
        System.out.println("this is Circle::draw");
    }
}
