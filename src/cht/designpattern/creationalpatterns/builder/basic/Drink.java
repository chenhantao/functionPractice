package cht.designpattern.creationalpatterns.builder.basic;

import cht.designpattern.creationalpatterns.basic.common.Food;
import cht.designpattern.creationalpatterns.basic.common.Packing;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public abstract class Drink implements Food {
    @Override
    public String name() {
        return "冷饮";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
