/* @author Kuvykin N.D CMC-21
MinHeap class
 */
import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Вставка элемента в кучу
    public void insert(int value) {
        heap.add(value); // Добавляем элемент в конец списка кучи
        int currentIndex = heap.size() - 1;

        // Поднимаем новый элемент вверх кучи, пока он не станет меньше своих родителей
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex) < heap.get(parentIndex)) {
                // Обмениваем элемент с родителем
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // Извлечение минимального элемента из кучи
    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Куча пуста");
        }

        int min = heap.get(0); // Минимальный элемент всегда в корне
        int lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            // Помещаем последний элемент в корень и опускаем его вниз кучи
            heap.set(0, lastElement);
            heapify(0);
        }

        return min;
    }

    // Поддержание свойства кучи (кучевой порядок)
    public void heapify(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != index) {
            // Обмениваем элемент с наименьшим потомком
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // Обмен элементов в куче
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Проверка, пуста ли куча
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Получение размера кучи
    public int size() {
        return heap.size();
    }

    // Метод для сортировки массива с использованием турнирной сортировки
    public static int[] tournamentSort(int[] array) {
        MinHeap tournamentHeap = new MinHeap();

        // Вставляем все элементы массива в кучу
        for (int value : array) {
            tournamentHeap.insert(value);
        }

        int[] sortedArray = new int[array.length];
        int index = 0;

        // Извлекаем минимальные элементы из кучи и добавляем их в отсортированный массив
        while (!tournamentHeap.isEmpty()) {
            sortedArray[index] = tournamentHeap.extractMin();
            index++;
        }

        return sortedArray;
    }
}

