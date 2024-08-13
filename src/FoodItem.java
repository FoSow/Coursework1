public class FoodItem {
    // Fields
    private final String name;
    private final FoodType type;

    // Constructor
    public FoodItem(String name, FoodType fruit, FoodType cheese, FoodType type) {
        this.name = name;
        this.type = type;
    }

    // Method to get the food type
    public FoodType getFoodType() {
        return type;
    }

    // Method to get the food name
    public String getFoodName() {
        return name;
    }

    // Main method to demonstrate the functionality
    public static void main() {
        // Create an example food item
        FoodItem item = new FoodItem("Damson", FoodType.FRUIT, FoodType.CHEESE, FoodType.FRUIT);

        // Get and print the food name and type
        System.out.println("Food Type: " + item.getFoodType());
        System.out.println("Food Name: " + item.getFoodName());
    }

    // Main method to demonstrate the functionality
    static {
        // Create an example food item
        FoodItem item = new FoodItem("Quatro", FoodType.FRUIT, FoodType.CHEESE, FoodType.DRINK);

        // Get and print the food name and type
        System.out.println("Food Type: " + item.getFoodType());
        System.out.println("Food Name: " + item.getFoodName());
        {
            // Create an example food item
            item = new FoodItem("Olivet Cendre", FoodType.FRUIT, FoodType.CHEESE, FoodType.CHEESE);
            // Get and print the food name and type
            System.out.println("Food Type: " + item.getFoodType());
            System.out.println("Food Name: " + item.getFoodName());
        }
    }

    public String getName() {
        return "";
    }
}
