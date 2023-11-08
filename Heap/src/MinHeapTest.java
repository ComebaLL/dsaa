/* @author Kuvykin N.D CMC-21
MinHeapTest class
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class MinHeapTest {

    // Тест для вставки в кучу и извлечение min-элемента
    @Test
    public void testInsertAndExtractMin() {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(2);

        assertEquals(2, minHeap.extractMin());
        assertEquals(3, minHeap.extractMin());
        assertEquals(5, minHeap.extractMin());
        assertEquals(7, minHeap.extractMin());
        assertTrue(minHeap.isEmpty());
    }

    // Тест на пустоту кучи
    @Test
    public void testIsEmpty() {
        MinHeap minHeap = new MinHeap();
        assertTrue(minHeap.isEmpty());

        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
    }

    // Тест размера кучи
    @Test
    public void testSize() {
        MinHeap minHeap = new MinHeap();
        assertEquals(0, minHeap.size());

        minHeap.insert(8);
        assertEquals(1, minHeap.size());

        minHeap.insert(4);
        assertEquals(2, minHeap.size());

        minHeap.extractMin();
        assertEquals(1, minHeap.size());
    }

    // Тест для проверки сво-ва кучи
        @Test
        public void testHeapify() {
            MinHeap minHeap = new MinHeap();

            // Вставляем элементы в произвольном порядке
            minHeap.insert(5);
            minHeap.insert(3);
            minHeap.insert(7);
            minHeap.insert(2);
            minHeap.insert(8);

            // Вызываем heapify для элемента в середине кучи (например, индекс 1)
            minHeap.heapify(1);

            // Проверяем, что кучевое свойство соблюдено
            assertTrue(checkHeapProperty(minHeap));
        }

        // Метод для проверки кучевого свойства
        private boolean checkHeapProperty(MinHeap minHeap) {
            if (minHeap.isEmpty()) {
                return true;
            }
            int minValue = minHeap.extractMin();
            minHeap.insert(minValue);
            return minValue == minHeap.extractMin();
        }

    // Тест турнирной сортировки
    @Test
    public void testTournamentSort() {
        int[] unsortedArray = {5, 3, 7, 2, 1, 8, 4, 6};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] sortedArray = MinHeap.tournamentSort(unsortedArray);

        assertArrayEquals(expectedSortedArray, sortedArray);
    }
}
