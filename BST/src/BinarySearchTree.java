/* Kuvykin N.D CMC-21 */
// класс Binary Search Tree
public class BinarySearchTree {
    // Корень дерева
    private Node root;

    // Конструктор по умолчанию
    public BinarySearchTree() {
        root = null;
    }

    // Метод для вставки значения в дерево
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Рекурсивный метод для вставки значения
    private Node insertRec(Node root, int key) {
        // Если дерево пусто, создаем новый узел и возвращаем его
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // В противном случае, рекурсивно идем влево или вправо в зависимости от значения ключа
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Метод для удаления значения из дерева
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Рекурсивный метод для удаления значения
    private Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        // Рекурсивно идем влево или вправо для поиска удаляемого значения
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Узел с одним или без детей
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Узел с двумя детьми, находим наименьший узел в правом поддереве
            root.key = minValue(root.right);

            // Удаляем наименьший узел в правом поддереве
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Метод для поиска значения в дереве
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Рекурсивный метод для поиска значения
    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // Возвращение корня дерева
    public Node getRoot() {
        return root;
    }

}
