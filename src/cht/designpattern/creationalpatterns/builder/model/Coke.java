package cht.designpattern.creationalpatterns.builder.model;

import cht.designpattern.creationalpatterns.builder.basic.Drink;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class Coke extends Drink {

    @Override
    public String name() {
        return "快乐水";
    }

    @Override
    public Double price() {
        return 5D;
    }
}
