/* Класс для представления узла списка
    Kuvykin N.D CMC-21
 */
class Node<T> {
    T data;  // Данные узла
    Node<T> next;  // Ссылка на следующий узел

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
