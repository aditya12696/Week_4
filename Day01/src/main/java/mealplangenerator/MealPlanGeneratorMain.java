package mealplangenerator;

public class MealPlanGeneratorMain {
    public static void main(String[] args) {
        // Create a meal planner
        MealPlanner planner = new MealPlanner();

        // Creating different meal plans
        Meal<VegetarianMeal> vegMeal = new Meal<>("Healthy Green Bowl", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Plant-Based Delight", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Power Meal", new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>("Muscle Builder", new HighProteinMeal());

        // Adding meals to the planner
        planner.addMeal(vegMeal);
        planner.addMeal(veganMeal);
        planner.addMeal(ketoMeal);
        planner.addMeal(proteinMeal);

        // Display the meal plan
        planner.displayMealPlan();
    }
}

