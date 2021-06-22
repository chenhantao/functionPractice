package cht.designpattern.creationalpatterns.basic.model.shape;

import cht.designpattern.creationalpatterns.basic.common.Shape;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/21
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("this is Rectangle::draw");
    }
}
