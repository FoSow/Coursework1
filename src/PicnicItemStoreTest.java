public static void main() {
    PicnicItemStore store = new PicnicItemStore();

    store.put("a", "apple");
    store.put("b", "banana");
    store.put("g", "grape");
    store.put("w", "watermelon");

    System.out.println("Random item for 'a': " + store.getRandomItem("a"));
    System.out.println("Random item for 'b': " + store.getRandomItem("b"));
    System.out.println("Random item for 'g': " + store.getRandomItem("g"));
    System.out.println("Random item for 'w': " + store.getRandomItem("w"));
    System.out.println("Random item for 'x': " + store.getRandomItem("x")); // Non-existent mapping
}
