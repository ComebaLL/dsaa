import java.util.ArrayList;
import java.util.List;

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

    // Рекурсивный метод для обхода в порядке возрастания и вывода элементов/ обход LNR
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

    // обход NLR
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(NodeTree<T> node) {
        if (node != null) {
            // Сначала выводим значение текущего узла
            System.out.print(node.data + " ");

            // Затем обходим левое поддерево
            preOrderTraversal(node.left);

            // Затем обходим правое поддерево
            preOrderTraversal(node.right);
        }
    }

    // обход LRN
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(NodeTree<T> node) {
        if (node != null) {
            // Сначала обходим левое поддерево
            postOrderTraversal(node.left);

            // Затем обходим правое поддерево
            postOrderTraversal(node.right);

            // Затем выводим значение текущего узла
            System.out.print(node.data + " ");
        }
    }

    // преращение в массив на основе LNR
    public List<T> toArrayInOrder() {
        List<T> result = new ArrayList<>();
        toArrayInOrder(root, result);
        return result;
    }

    private void toArrayInOrder(NodeTree<T> node, List<T> result) {
        if (node != null) {
            // Сначала обходим левое поддерево
            toArrayInOrder(node.left, result);

            // Затем добавляем значение текущего узла в массив
            result.add(node.data);

            // Затем обходим правое поддерево
            toArrayInOrder(node.right, result);
        }
    }

    // удаление дерева обходом LNR
    public void deleteTreeInOrder() {
        deleteTreeInOrder(root);
        root = null; // Устанавливаем корень в null, чтобы полностью удалить дерево
    }

    private void deleteTreeInOrder(NodeTree<T> node) {
        if (node != null) {
            // Сначала обходим левое поддерево
            deleteTreeInOrder(node.left);

            // Затем обходим правое поддерево
            deleteTreeInOrder(node.right);

            // Удаляем текущий узел
            node.left = null;
            node.right = null;
        }
    }

    // увеличение каждого узла на еденицу
    public void incrementTreeValues() {
        incrementTreeValues(root);
    }

    private void incrementTreeValues(NodeTree<T> node) {
        if (node != null) {
            // Сначала обходим левое поддерево
            incrementTreeValues(node.left);

            // Увеличиваем значение текущего узла на единицу
            node.data = (T) Integer.valueOf(((Integer)node.data).intValue() + 1);

            // Затем обходим правое поддерево
            incrementTreeValues(node.right);
        }
    }

    // проверка есть ли значение в дереве или нет
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(NodeTree<T> node, T data) {
        if (node == null) {
            return false;
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult == 0) {
            return true; // Значение найдено
        } else if (compareResult < 0) {
            return contains(node.left, data); // Идем влево
        } else {
            return contains(node.right, data); // Идем вправо
        }
    }


}


