package cht.designpattern.creationalpatterns.builder.model;

import cht.designpattern.creationalpatterns.builder.basic.Burger;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "鸡肉汉堡";
    }

    @Override
    public Double price() {
        return 10D;
    }
}
