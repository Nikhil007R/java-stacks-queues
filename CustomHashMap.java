import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 10; // Default size of HashMap
    private LinkedList<Entry<K, V>>[] map;

    public CustomHashMap() {
        map = new LinkedList[SIZE]; // Create array of linked lists
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to compute index
    private int getIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) { // If key exists, update value
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // Insert new key-value pair
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Entry class to store key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.put("Rice", 100);
        hashMap.put("Wheat", 200);
        hashMap.put("Protein", 300);

        System.out.println("Value for 'Rice': " + hashMap.get("Rice")); // 100
        System.out.println("Value for 'Protein': " + hashMap.get("Protein")); // 200

        hashMap.remove("Rice");
        System.out.println("Value for 'Rice' after removal: " + hashMap.get("Rice")); // null
    }
}
