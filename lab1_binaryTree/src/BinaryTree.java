/* class binary search tree */
/* @author Kuvykin Nikita */
class BinaryTree<T extends Comparable<T>> {
    NodeTree<T> root;

    // Конструктор для создания пустого дерева
    public BinaryTree() {
        root = null;
    }

    // Метод для добавления узла в дерево
    public void insert(T data) {
        root = insertRec(root, data);
    }

    // Рекурсивный метод для вставки узла в дерево
    private NodeTree<T> insertRec(NodeTree<T> root, T data) {
        if (root == null) {
            root = new NodeTree<>(data);
            return root;
        }

        // Рекурсивно идем влево, если значение меньше корневого узла
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        }
        // Рекурсивно идем вправо, если значение больше или равно корневому узлу
        else if (data.compareTo(root.data) >= 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Вспомогательный метод для поиска наименьшего элемента в дереве
    private T minValue(NodeTree<T> root) {
        T minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Рекурсивный метод для удаления узла с заданным значением из дерева
    private NodeTree<T> deleteRec(NodeTree<T> root, T data) {
        // Если дерево пусто, возвращаем null
        if (root == null) {
            return root;
        }

        // Рекурсивно идем влево, если значение меньше корневого узла
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        }
        // Рекурсивно идем вправо, если значение больше корневого узла
        else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        }
        // Если узел с заданным значением найден
        else {
            // Узел с одним или без детей
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Узел с двумя детьми, найдем наименьший элемент в правом поддереве (преемника)
            root.data = minValue(root.right);

            // Удаляем найденный преемник
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Метод для удаления узла с заданным значением из дерева
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    // Метод для выполнения обхода в порядке возрастания и вывода элементов
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    // Рекурсивный метод для обхода в порядке возрастания и вывода элементов
    private void inOrderTraversal(NodeTree<T> node) {
        if (node != null) {
            // Сначала обходим левое поддерево
            inOrderTraversal(node.left);

            // Затем выводим значение текущего узла
            System.out.print(node.data + " ");

            // Затем обходим правое поддерево
            inOrderTraversal(node.right);
        }
    }

    // Подсчет кол-во узлов в дереве
    public int countNodes() {
        return countNodes(root);
    }

    // Рекурсивный метод для подсчета количества узлов в дереве
    private int countNodes(NodeTree<T> node) {
        if (node == null) {
            return 0;
        }
        // Количество узлов в дереве равно 1 (текущий узел) плюс сумма количества узлов в левом и правом поддеревьях
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Метод для удаления всего дерева путем обнуления корневого узла
    public void deleteTree() {
        root = null;
    }

    public int depth() {
        return depth(root);
    }

    // Метод для определения глубины дерева
    private int depth(NodeTree<T> node) {
        if (node == null) {
            return 0;
        }
        // Глубина дерева равна 1 (текущий узел) плюс максимальная глубина из левого и правого поддеревьев
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }




}


