package cht.designpattern.creationalpatterns.builder.basic;

import cht.designpattern.creationalpatterns.basic.common.Packing;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "瓶子";
    }
}
