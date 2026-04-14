package com.gla.generics;

import java.util.*;


// 1. Base Interface
interface MealPlan {
    String getName();
    String getDescription();
}

// 2. Different Meal Types

class VegetarianMeal implements MealPlan {
    public String getName() {
        return "Vegetarian Meal";
    }

    public String getDescription() {
        return "Plant-based meal with dairy and vegetables.";
    }
}

class VeganMeal implements MealPlan {
    public String getName() {
        return "Vegan Meal";
    }

    public String getDescription() {
        return "Strictly plant-based meal with no animal products.";
    }
}

class KetoMeal implements MealPlan {
    public String getName() {
        return "Keto Meal";
    }

    public String getDescription() {
        return "High-fat, low-carb meal plan.";
    }
}

class HighProteinMeal implements MealPlan {
    public String getName() {
        return "High Protein Meal";
    }

    public String getDescription() {
        return "Protein-rich meal for muscle building.";
    }
}


// 3. Generic Class
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMeal() {
        System.out.println("Meal: " + mealPlan.getName());
        System.out.println("Details: " + mealPlan.getDescription());
        System.out.println("----------------------------");
    }
}


// 4. Utility class with Generic Method
class MealPlanner {

    // Generic method with bounded type
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        if (meal == null) {
            throw new IllegalArgumentException("Invalid meal plan selection!");
        }

        System.out.println("Generating personalized meal plan...");
        return new Meal<>(meal);
    }

    // Generic method using wildcard (read-only processing)
    public static void printAvailableMeals(List<? extends MealPlan> meals) {
        for (MealPlan meal : meals) {
            System.out.println(meal.getName() + " -> " + meal.getDescription());
        }
    }
}


// 5. Main Class
public class MealPlanSystem {
    public static void main(String[] args) {

        // Create meal objects
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal protein = new HighProteinMeal();

        // Generic method usage (validation + generation)
        Meal<VegetarianMeal> m1 = MealPlanner.generateMealPlan(veg);
        Meal<VeganMeal> m2 = MealPlanner.generateMealPlan(vegan);
        Meal<KetoMeal> m3 = MealPlanner.generateMealPlan(keto);

        // Display meals
        m1.displayMeal();
        m2.displayMeal();
        m3.displayMeal();

        // Wildcard usage
        List<MealPlan> allMeals = new ArrayList<>();
        allMeals.add(veg);
        allMeals.add(vegan);
        allMeals.add(keto);
        allMeals.add(protein);

        System.out.println("\n=== Available Meal Plans ===");
        MealPlanner.printAvailableMeals(allMeals);
    }
}
