/* Kuvykin N.D CMC-21 */
// Iterator for class Binary Search Tree
import java.util.Iterator;
import java.util.Stack;

// обход дерева в порядке восхождения
public class BinarySearchTreeIterator implements Iterator<Integer> {
    private Node current; // Текущий узел, который будет возвращаться при вызове next()
    private Stack<Node> stack; // Стек для обхода дерева

    public BinarySearchTreeIterator(Node root) {
        current = root; // Инициализируем текущий узел корневым узлом
        stack = new Stack<>(); // Инициализируем стек для хранения узлов в порядке обхода
        pushLeftChildren(root); // Первоначально добавляем левых потомков корневого узла в стек
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty(); // Возвращает true, если в стеке ещё остались узлы для обхода
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException(); // Бросаем исключение, если больше нет элементов для возврата
        }

        Node node = stack.pop(); // Извлекаем узел из стека
        pushLeftChildren(node.right); // Добавляем левых потомков правого поддерева (если есть) в стек
        return node.key; // Возвращаем ключ извлеченного узла
    }

    // Метод для добавления всех левых потомков узла в стек
    private void pushLeftChildren(Node node) {
        while (node != null) {
            stack.push(node); // Добавляем узел в стек
            node = node.left; // Переходим к левому потомку
        }
    }
}

