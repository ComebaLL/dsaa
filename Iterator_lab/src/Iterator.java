/* Kuvykin .N.D CMC-21*/
// шаблоный класс Iterator
public class Iterator<T> {
    private T[] data;  // Массив данных
    private int current;  // Текущий индекс
    private int length;  // Длина массива

    public Iterator(T[] data) {
        this.data = data;
        this.current = 0;
        this.length = data.length;
    }

    // Метод для получения итератора, указывающего на начало коллекции
    public void begin() {
        current = 0;
    }

    // Метод для получения итератора, указывающего на конец коллекции
    public void end() {
        current = length;
    }

    // Метод для сравнения итераторов на равенство
    public boolean equals(Iterator<T> other) {
        return this.current == other.current;
    }

    // Метод для сравнения итераторов на неравенство
    public boolean notEquals(Iterator<T> other) {
        return this.current != other.current;
    }

    // Метод для получения текущего элемента
    public T data() {
        if (current >= 0 && current < length) {
            return data[current];
        } else {
            throw new IndexOutOfBoundsException("Итератор находится за пределами коллекции.");
        }
    }

    // Метод для префиксного инкремента (переход к следующему элементу)
    public void preIncrement() {
        if (current < length) {
            current++;
        }
    }

    // Метод для постфиксного инкремента (переход к следующему элементу)
    public void postIncrement() {
        preIncrement();
    }

    // Метод для перехода к следующему элементу
    public void next() {
        preIncrement();
    }

    // Метод для сброса итератора
    public void reset() {
        current = 0;
    }

    // Метод для проверки, достигнут ли конец коллекции
    public boolean isEnd() {
        return current >= length;
    }
}

