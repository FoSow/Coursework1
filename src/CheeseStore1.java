import java.util.*;

class CheeseStore {
    private Map<String, List<String>> itemMap;

    public CheeseStore() {
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
        return capitalizeKey(key) + " " + randomItem.toLowerCase();
    }

    private String capitalizeKey(String key) {
        return key.toUpperCase();
    }
}

class CheeseStore1 extends PicnicItemStore {
    @Override
    public void put(String key, String item) {
        super.put(key, item + " (cheese)");
    }
}
