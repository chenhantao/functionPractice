package cht.designpattern.creationalpatterns.basic.model.shape;

import cht.designpattern.creationalpatterns.basic.common.Shape;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/21
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("this is Square::draw");
    }
}
