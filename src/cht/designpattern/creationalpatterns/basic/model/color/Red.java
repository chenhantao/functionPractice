package cht.designpattern.creationalpatterns.basic.model.color;

import cht.designpattern.creationalpatterns.basic.common.Color;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("this is red::fill");
    }
}
