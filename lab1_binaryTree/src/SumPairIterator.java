import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* класс итератор для BST
    Kuvykin N.D CMC-21
 */
class SumPairIterator<U extends Comparable<U>> implements Iterator<Integer> {
    private Stack<NodeTree<U>> stack;
    private List<Integer> sumList;

    // Конструктор итератора
    public SumPairIterator() {
        stack = new Stack<>();
        sumList = new ArrayList<>();
        // Начинаем с добавления всех левых узлов в стек, начиная с корня
        NodeTree<U> root = null;
        pushLeftNodes(root);
    }

    // Проверка наличия следующего элемента для обхода
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Получение следующего элемента в порядке возрастания
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        // Извлекаем верхний узел из стека
        NodeTree<U> current = stack.pop();
        // Добавляем все левые узлы из правого поддерева в стек
        pushLeftNodes(current.right);

        // Добавляем сумму текущего узла и следующего узла в список
        if (current.right != null) {
            sumList.add(current.data.hashCode() + current.right.data.hashCode());
        }

        // Возвращаем значение текущего узла
        return current.data.hashCode();
    }

    // Вспомогательный метод для добавления всех левых узлов в стек
    private void pushLeftNodes(NodeTree<U> node) {
        while (node != null) {
            stack.push(node);
            // Перемещаемся влево, добавляя узлы в стек
            node = node.left;
        }
    }

    // Метод для получения массива сумм пар
    public List<Integer> getSumList() {
        return sumList;
    }


    // Метод для получения итератора с суммой пар
    public <U extends Comparable<U>> Iterator<Integer> sumPairIterator() {
        return new SumPairIterator<U>();
    }
}
