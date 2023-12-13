/* Kuvykin N.D CMC-21

 */
public class Main {
    public static void main(String[] args) {
        // Пример использования
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("Value for key 'two': " + hashTable.get("two")); // Вывод: Value for key 'two': 2

        hashTable.remove("two");
        System.out.println("Value for key 'two' after removal: " + hashTable.get("two")); // Вывод: Value for key 'two' after removal: null
    }
}