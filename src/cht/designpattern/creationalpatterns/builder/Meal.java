package cht.designpattern.creationalpatterns.builder;

import java.util.ArrayList;
import java.util.List;

import cht.designpattern.creationalpatterns.basic.common.Food;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class Meal {
    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public Double getCost() {
        return foods.stream().mapToDouble(Food::price).sum();
    }

    public void showFoods() {
        foods.forEach(food -> {
            System.out.print("food : " + food.name());
            System.out.print(", Packing : " + food.packing().pack());
            System.out.println(", Price : " + food.price());
        });
    }
}
