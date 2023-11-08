/* @author Kuvykin N.D CMC-21
AVLTree class
 */
class AVLTree {
    class Node {
        int key, height;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    protected Node root;

    // Возвращает высоту узла
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Возвращает баланс-фактор узла
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Обновляет высоту узла
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Райт ротейшн поддерева, корень которого - node
    public Node rightRotate(Node node) {
        Node newRoot = node.left;
        Node newRootRight = newRoot.right;

        // Поворот
        newRoot.right = node;
        node.left = newRootRight;

        // Обновление высот
        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    // Лефт ротейшн поддерева, корень которого - node
    public Node leftRotate(Node node) {
        Node newRoot = node.right;
        Node newRootLeft = newRoot.left;

        // Поворот
        newRoot.left = node;
        node.right = newRootLeft;

        // Обновление высот
        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    // Вставка ключа k в дерево с корнем node
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Дублирующие ключи не допускаются
            return node;
        }

        // Обновление высоты текущего узла
        updateHeight(node);

        // Получение баланс-фактора
        int balance = getBalance(node);

        // Проверка нарушения баланса и восстановление
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Вставка ключа в AVL-дерево
    public void insert(int key) {
        root = insert(root, key);
    }

    // Вспомогательная функция для вывода дерева в виде инфиксной последовательности
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    // Вывод дерева в виде инфиксной последовательности
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    // Проверка сбалансированости дерева
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balance = getBalance(node);

        return Math.abs(balance) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

}

