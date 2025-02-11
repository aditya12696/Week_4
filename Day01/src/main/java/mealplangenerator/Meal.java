package mealplangenerator;

// Generic class for handling different meal plans
public class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    // Constructor initializes meal name and type
    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    // Getter for meal name
    public String getMealName() {
        return mealName;
    }

    // Getter for meal type
    public T getMealType() {
        return mealType;
    }

    // Display meal information
    public void displayMealInfo() {
        System.out.println("Meal: " + mealName + " | Type: " + mealType.getMealDetails());
    }
}

