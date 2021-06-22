package cht.designpattern.creationalpatterns.builder;

import cht.designpattern.creationalpatterns.builder.model.ChickenBurger;
import cht.designpattern.creationalpatterns.builder.model.Coke;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class MealBuilder {
    public Meal ChickenAndCoke() {
        Meal meal = new Meal();
        meal.addFood(new ChickenBurger());
        meal.addFood(new Coke());
        return meal;
    }
}
