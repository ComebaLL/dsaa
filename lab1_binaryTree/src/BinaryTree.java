/* class binary tree */
/* @author Kuvykin Nikita */
class BinaryTree {
    NodeTree root;

    // Конструктор для создания пустого дерева
    public BinaryTree() {
        root = null;
    }

    // Метод для добавления узла в дерево
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Рекурсивный метод для вставки узла в дерево
    private NodeTree insertRec(NodeTree root, int data) {
        if (root == null) {
            root = new NodeTree(data);
            return root;
        }

        // Рекурсивно идем влево, если значение меньше корневого узла
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        }
        // Рекурсивно идем вправо, если значение больше или равно корневому узлу
        else if (data >= root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Вспомогательный метод для поиска наименьшего элемента в дереве
    private int minValue(NodeTree root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Рекурсивный метод для удаления узла с заданным значением из дерева
    private NodeTree deleteRec(NodeTree root, int data) {
        // Если дерево пусто, возвращаем null
        if (root == null) {
            return root;
        }

        // Рекурсивно идем влево, если значение меньше корневого узла
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        }
        // Рекурсивно идем вправо, если значение больше корневого узла
        else if (data > root.data) {
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
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Метод для выполнения обхода в порядке возрастания и вывода элементов
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    // Рекурсивный метод для обхода в порядке возрастания и вывода элементов
    private void inOrderTraversal(NodeTree node) {
        if (node != null) {
            // Сначала обходим левое поддерево
            inOrderTraversal(node.left);

            // Затем выводим значение текущего узла
            System.out.print(node.data + " ");

            // Затем обходим правое поддерево
            inOrderTraversal(node.right);
        }
    }

}

