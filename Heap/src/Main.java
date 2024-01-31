/* @author Kuvykin N.D CMC-21
Heap class
 */
public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();

        // Вставляем элементы в кучу
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(2);

        // Извлекаем и выводим минимальные элементы на экран
        while (!minHeap.isEmpty()) {
            Integer min = minHeap.extractMin();
            System.out.println("min el: " + min);
        }
    }
}
