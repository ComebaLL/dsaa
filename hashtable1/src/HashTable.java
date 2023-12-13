/* Kuvykin N.D CMC-21
    My class Hash table
 */
import java.util.LinkedList;

// Шаблонный класс для хэш-таблицы
public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    // Внутренний класс для представления записи в хэш-таблице
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Конструктор с заданным начальным размером
    public HashTable(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Invalid initial capacity");
        }
        table = new LinkedList[initialCapacity];
        size = 0;
    }

    // Конструктор с размером по умолчанию
    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    // Метод для добавления элемента в хэш-таблицу
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Проверяем, существует ли уже запись с данным ключом
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Обновляем значение, если ключ уже существует
                return;
            }
        }

        // Если записи с таким ключом нет, добавляем новую
        table[index].add(new Entry<>(key, value));
        size++;

        // Проверяем, нужно ли увеличить размер таблицы
        if (size > table.length * 0.75) {
            resize();
        }
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Если ключ не найден
    }

    // Метод для удаления записи по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    // Вспомогательный метод для вычисления хэша ключа
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    // Вспомогательный метод для увеличения размера таблицы
    private void resize() {
        int newCapacity = table.length * 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];

        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = hash(entry.key);
                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }
                    newTable[index].add(entry);
                }
            }
        }

        table = newTable;
    }

    // Метод для получения текущего размера таблицы
    public int getSize() {
        return size;
    }

}

