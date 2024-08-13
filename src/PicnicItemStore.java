import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PicnicItemStore {

    // Instance variable to store key-item mappings
    private Map<String, List<String>> itemMap;

    // No-argument constructors
    public PicnicItemStore() {
        itemMap = new HashMap<>();
    }

    // Method to add a key-item pair to the store
    public void put(String key, String item) {
        key = key.toLowerCase(); // Normalize key to lower case for case insensitivity
        itemMap.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
    }

    // Method to get a random item associated with a key
    public String getRandomItem(String key) {
        key = key.toLowerCase(); // Normalize key to lower case for case insensitivity
        List<String> items = itemMap.get(key);
        if (items == null || items.isEmpty()) {
            return null;
        }
        Random random = new Random();
        String randomItem = items.get(random.nextInt(items.size()));
        return capitalizeKeyInItem(randomItem, key);
    }

    // Helper method to capitalize key in the item
    private String capitalizeKeyInItem(String item, String key) {
        String lowerCaseItem = item.toLowerCase();
        String lowerCaseKey = key.toLowerCase();
        int index = lowerCaseItem.indexOf(lowerCaseKey);
        if (index != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(lowerCaseItem, 0, index);
            sb.append(lowerCaseItem.substring(index, index + lowerCaseKey.length()).toUpperCase());
            sb.append(lowerCaseItem.substring(index + lowerCaseKey.length()));
            return sb.toString();
        }
        return item;
    }

    public static void main(String[] args) {
        PicnicItemStore store = new PicnicItemStore();
        store.put("fruit", "apple");
        store.put("fruit", "banana");
        store.put("fruit", "grape");
        store.put("drink", "water");
        store.put("drink", "orange juice");

        System.out.println(store.getRandomItem("fruit")); // Randomly returns "apple", "banana", or "grape" with "fruit" part capitalized
        System.out.println(store.getRandomItem("drink")); // Randomly returns "water" or "orange juice" with "drink" part capitalized
        System.out.println(store.getRandomItem("snack")); // Returns null as no items mapped to "snack"
    }
}
