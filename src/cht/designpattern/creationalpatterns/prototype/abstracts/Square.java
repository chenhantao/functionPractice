package cht.designpattern.creationalpatterns.prototype.abstracts;

import cht.designpattern.creationalpatterns.basic.enums.ShapeTypeEnum;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class Square extends Shape {

    public Square() {
        type = ShapeTypeEnum.SQUARE.getType();
    }

    @Override
    public void draw() {
        System.out.println("this is Square::draw");
    }
}
