/* @author Kuvykin N.D CMC-21
MinHeapTest class
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class MinHeapTest {

    // Тест для вставки в кучу и извлечения min-элемента
    @Test
    public void testInsertAndExtractMin() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(2);

        assertEquals(Integer.valueOf(2), minHeap.extractMin());
        assertEquals(Integer.valueOf(3), minHeap.extractMin());
        assertEquals(Integer.valueOf(5), minHeap.extractMin());
        assertEquals(Integer.valueOf(7), minHeap.extractMin());
        assertTrue(minHeap.isEmpty());
    }

    // Тест на пустоту кучи
    @Test
    public void testIsEmpty() {
        MinHeap<Integer> minHeap = new MinHeap<>();
        assertTrue(minHeap.isEmpty());

        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
    }

    // Тест размера кучи
    @Test
    public void testSize() {
        MinHeap<Integer> minHeap = new MinHeap<>();
        assertEquals(0, minHeap.size());

        minHeap.insert(8);
        assertEquals(1, minHeap.size());

        minHeap.insert(4);
        assertEquals(2, minHeap.size());

        minHeap.extractMin();
        assertEquals(1, minHeap.size());
    }

    // Тест для проверки свойства кучи
    @Test
    public void testHeapify() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        // Вставляем элементы в произвольном порядке
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(2);
        minHeap.insert(8);

        // Вызываем heapify для элемента в середине кучи (например, индекс 1)
        minHeap.heapify(1, minHeap.size());

        // Проверяем, что кучевое свойство соблюдено
        assertTrue(checkHeapProperty(minHeap));
    }

    // Метод для проверки кучевого свойства
    private boolean checkHeapProperty(MinHeap<Integer> minHeap) {
        if (minHeap.isEmpty()) {
            return true;
        }
        int minValue = minHeap.extractMin();
        minHeap.insert(minValue);
        return minValue == minHeap.extractMin();
    }

    // Тест пирамидальной сортировки
    @Test
    public void testHeapSort() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        // Вставляем элементы в произвольном порядке
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(2);
        minHeap.insert(8);

        // Сортируем кучу
        Integer[] sortedArray = minHeap.heapSort();

        // Проверяем, что куча отсортирована
        Integer[] expectedSortedArray = {2, 3, 5, 7, 8};
        assertArrayEquals(expectedSortedArray, sortedArray);
    }

    // Тест для проверки метода tournamentSort
    @Test
    public void testTournamentSort() {
        Integer[] unsortedArray = {5, 3, 7, 2, 1, 8, 4, 6};
        Integer[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

        Integer[] sortedArray = MinHeap.tournamentSort(unsortedArray);

        assertArrayEquals(expectedSortedArray, sortedArray);
    }
}


