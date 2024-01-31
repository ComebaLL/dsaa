/* класс куча
    Kuvykin N.D CMC-21
 */
import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Вставка элемента в кучу
    public void insert(T value) {
        heap.add(value); // Добавляем элемент в конец списка кучи
        int currentIndex = heap.size() - 1;

        // Поднимаем новый элемент вверх кучи, пока он не станет меньше своих родителей
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
                // Обмениваем элемент с родителем
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // Извлечение минимального элемента из кучи
    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Куча пуста");
        }

        T min = heap.get(0); // Минимальный элемент всегда в корне
        T lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            // Помещаем последний элемент в корень и опускаем его вниз кучи
            heap.set(0, lastElement);
            heapify(0, heap.size());
        }

        return min;
    }

    // Поддержание свойства кучи (кучевой порядок)
    public void heapify(int index, int size) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < size && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }
        if (rightChild < size && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            // Обмениваем элемент с наименьшим потомком
            swap(index, smallest);
            heapify(smallest, size);
        }
    }

    // Обмен элементов в куче
    private void swap(int i, int j) {
        T temp = heap.get(i);
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
    public static <U extends Comparable<U>> U[] tournamentSort(U[] array) {
        MinHeap<U> tournamentHeap = new MinHeap<>();

        // Вставляем все элементы массива в кучу
        for (U value : array) {
            tournamentHeap.insert(value);
        }

        U[] sortedArray = (U[]) new Comparable[array.length];
        int index = 0;

        // Извлекаем минимальные элементы из кучи и добавляем их в отсортированный массив
        while (!tournamentHeap.isEmpty()) {
            sortedArray[index] = tournamentHeap.extractMin();
            index++;
        }

        return sortedArray;
    }

    // Метод для сортировки кучи с использованием алгоритма пирамидальной сортировки
    public T[] heapSort() {
        int size = heap.size();
        T[] sortedArray = (T[]) new Comparable[size];

        // Построение кучи
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i, size);
        }

        // Извлечение элементов из кучи и вставка их в конец списка (отсортированный порядок)
        for (int i = size - 1; i > 0; i--) {
            sortedArray[i] = extractMin();
            heapify(0, i);
        }
        sortedArray[0] = extractMin();

        return sortedArray;
    }
}


