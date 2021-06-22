package cht.designpattern.creationalpatterns.builder;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/23
 */
public class BuilderTest {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.ChickenAndCoke();
        meal.showFoods();
        System.out.println(meal.getCost());
    }
}
