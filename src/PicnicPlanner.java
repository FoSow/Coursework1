//We will now write a class PicnicPlanner than generates picnic plans.
//It should load a PicnicItemStore for the fruits, a CheeseStore for the cheeses, and finally a DrinkStore for the drinks.
// It will then use these stores to make plans. The design of this class is up to you, but you will at least need a main method where the program starts.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PicnicPlanner {
    private Map<Character, String> fruits;
    private Map<Character, String> cheeses;
    private Map<Character, String> drinks;

    public PicnicPlanner() {
        fruits = new HashMap<>();
        cheeses = new HashMap<>();
        drinks = new HashMap<>();
    }

    public void loadItems(String fruitFilePath, String cheeseFilePath, String drinkFilePath) {
        loadStore(fruitFilePath, fruits);
        loadStore(cheeseFilePath, cheeses);
        loadStore(drinkFilePath, drinks);
    }

    private void loadStore(String filePath, Map<Character, String> store) {
        FoodItemInputStream foodItemInputStream = null;
        try {
            foodItemInputStream = new FoodItemInputStream(new FileInputStream(filePath));
            FoodItem item;
            while ((item = foodItemInputStream.readItem()) != null) {
                String name = item.getName();
                store.put(name.charAt(0), name);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        } finally {
            if (foodItemInputStream != null) {
                try {
                    foodItemInputStream.close();
                } catch (IOException e) {
                    System.err.println("Error closing FoodItemInputStream");
                }
            }
        }
    }

    public void printItems() {
        System.out.println("Fruits: " + fruits);
        System.out.println("Cheeses: " + cheeses);
        System.out.println("Drinks: " + drinks);
    }

    public static void main(String[] args) {
        PicnicPlanner planner = new PicnicPlanner();
        planner.loadItems("fruits.txt", "cheeses.txt", "drinks.txt");
        planner.printItems();
    }
}
