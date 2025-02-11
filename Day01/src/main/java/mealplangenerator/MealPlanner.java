package mealplangenerator;

import java.util.ArrayList;
import java.util.List;

// MealPlanner class for dynamically generating meal plans
public class MealPlanner {
    public List<Meal<? extends MealPlan>> mealList;

    // Constructor initializes meal list
    public MealPlanner() {
        this.mealList = new ArrayList<>();
    }

    // Generic method to add meals to the planner
    public <T extends MealPlan> void addMeal(Meal<T> meal) {
        mealList.add(meal);
    }

    // Display all planned meals
    public void displayMealPlan() {
        System.out.println("\n Personalized Meal Plan:");
        for (Meal<? extends MealPlan> meal : mealList) {
            meal.displayMealInfo();
        }
    }
}
