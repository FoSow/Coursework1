import java.util.*;

class DrinksStore {
    private Map<String, List<String>> itemMap;

    public DrinksStore() {
        itemMap = new HashMap<>();
    }

    public void put(String key, String item) {
        key = key.toLowerCase();
        itemMap.putIfAbsent(key, new ArrayList<>());
        itemMap.get(key).add(item);
    }

    public String getRandomItem(String key) {
        key = key.toLowerCase();
        List<String> items = itemMap.get(key);
        if (items == null || items.isEmpty()) {
            return null;
        }
        Random random = new Random();
        String randomItem = items.get(random.nextInt(items.size()));
        return key.toUpperCase() + randomItem.toLowerCase().substring(key.length());
    }
}

class DrinkStore extends PicnicItemStore {

    @Override
    public void put(String key, String item) {
        super.put(key, item + " (drink)");
    }
}
