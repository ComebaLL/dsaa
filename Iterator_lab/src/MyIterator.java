/* Kuvykin .N.D CMC-21*/
// шаблоный класс myMyIterator переделать для связанного списка
public class MyIterator<T> {
    private Node<T> current;  // Текущий узел

    public MyIterator(Node<T> start) {
        this.current = start;
    }

    // Метод для получения текущего узла
    public Node<T> getCurrentNode() {
        return current;
    }

    // Метод для сравнения итераторов на равенство
    public boolean equals(MyIterator<T> other) {
        return this.current == other.current;
    }

    // Метод для сравнения итераторов на неравенство
    public boolean notEquals(MyIterator<T> other) {
        return this.current != other.current;
    }

    // Метод для получения текущего элемента
    public T data() {
        if (current != null) {
            return current.data;
        } else {
            throw new IndexOutOfBoundsException("Итератор находится за пределами коллекции.");
        }
    }

    // Метод для перехода к следующему элементу
    public void next() {
        if (current != null) {
            current = current.next;
        }
    }

    // Метод для проверки, достигнут ли конец коллекции
    public boolean isEnd() {
        return current == null;
    }
}

