/* Kuvykin N.D CMC-21
    My class Hash table test
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testPutAndGet() {
        // Тест: добавление и получение значений из хэш-таблицы
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        assertEquals(Integer.valueOf(1), hashTable.get("one"));
        assertEquals(Integer.valueOf(2), hashTable.get("two"));
        assertEquals(Integer.valueOf(3), hashTable.get("three"));
    }

    @Test
    public void testPutDuplicateKey() {
        // Тест: обработка дубликата ключа при добавлении
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("one", 1);
        hashTable.put("one", 11);

        assertEquals(Integer.valueOf(11), hashTable.get("one"));
    }

    @Test
    public void testRemove() {
        // Тест: удаление элемента из хэш-таблицы
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        hashTable.remove("two");

        assertNull(hashTable.get("two"));
    }

    @Test
    public void testResize() {
        // Тест: изменение размера хэш-таблицы при добавлении элемента
        HashTable<String, Integer> hashTable = new HashTable<>(2);

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        // Размер таблицы увеличится после добавления третьего элемента
        assertTrue(hashTable.getSize() > 2);
    }
}


