package cht.designpattern.creationalpatterns.builder.basic;

import cht.designpattern.creationalpatterns.basic.common.Food;
import cht.designpattern.creationalpatterns.basic.common.Packing;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public abstract class Burger implements Food {
    @Override
    public String name() {
        return "汉堡";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
