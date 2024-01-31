/* Класс для представления связанного списка и его методов
    Kuvykin N.D. CMC-21
 */
class MyLinkedList<T> {
    private Node<T> start;  // Начальный узел списка

    public MyLinkedList(Node<T> start) {
        this.start = start;
    }

    // Метод для получения итератора, указывающего на начало коллекции
    public MyIterator<T> begin() {
        return new MyIterator<>(start);
    }

    // Метод для получения итератора, указывающего на конец коллекции
    public MyIterator<T> end() {
        return new MyIterator<>(null);
    }
}