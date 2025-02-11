package mealplangenerator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class MealPlannerTest extends MealPlanGeneratorMain{
    private MealPlanner planner;

    @BeforeEach
    void setUp() {
        planner = new MealPlanner();
    }

    @Test
    void testMealPlanProperties() {
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        assertEquals("Vegetarian Meal: Includes fruits, vegetables, grains, dairy.", vegetarianMeal.getMealDetails());

        VeganMeal veganMeal = new VeganMeal();
        assertEquals("Vegan Meal: Includes plant-based foods, no dairy or animal products.", veganMeal.getMealDetails());

        KetoMeal ketoMeal = new KetoMeal();
        assertEquals("Keto Meal: High fat, low carb diet with meat, fish, and healthy fats.", ketoMeal.getMealDetails());

        HighProteinMeal highProteinMeal = new HighProteinMeal();
        assertEquals("High-Protein Meal: Includes lean meats, eggs, dairy, and legumes.", highProteinMeal.getMealDetails());
    }

    @Test
    void testMealCreation() {
        Meal<VegetarianMeal> vegMeal = new Meal<>("Healthy Green Bowl", new VegetarianMeal());
        assertEquals("Healthy Green Bowl", vegMeal.getMealName());
        assertEquals("Vegetarian Meal: Includes fruits, vegetables, grains, dairy.", vegMeal.getMealType().getMealDetails());

        Meal<VeganMeal> veganMeal = new Meal<>("Plant-Based Delight", new VeganMeal());
        assertEquals("Plant-Based Delight", veganMeal.getMealName());
        assertEquals("Vegan Meal: Includes plant-based foods, no dairy or animal products.", veganMeal.getMealType().getMealDetails());

        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Power Meal", new KetoMeal());
        assertEquals("Keto Power Meal", ketoMeal.getMealName());
        assertEquals("Keto Meal: High fat, low carb diet with meat, fish, and healthy fats.", ketoMeal.getMealType().getMealDetails());

        Meal<HighProteinMeal> proteinMeal = new Meal<>("Muscle Builder", new HighProteinMeal());
        assertEquals("Muscle Builder", proteinMeal.getMealName());
        assertEquals("High-Protein Meal: Includes lean meats, eggs, dairy, and legumes.", proteinMeal.getMealType().getMealDetails());
    }

    @Test
    void testMealPlannerOperations() {
        Meal<VegetarianMeal> vegMeal = new Meal<>("Healthy Green Bowl", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Plant-Based Delight", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Power Meal", new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>("Muscle Builder", new HighProteinMeal());

        planner.addMeal(vegMeal);
        planner.addMeal(veganMeal);
        planner.addMeal(ketoMeal);
        planner.addMeal(proteinMeal);

        assertEquals(4, planner.mealList.size());
    }
}
