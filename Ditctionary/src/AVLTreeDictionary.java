class AVLTreeDictionary<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        int height;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    // Возвращает высоту узла
    private int height(Node node) {
        return (node != null) ? node.height : 0;
    }

    // Обновляет высоту узла
    private void updateHeight(Node node) {
        if (node != null) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    // Возвращает балансовый фактор узла
    private int balanceFactor(Node node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    // Малое правое вращение
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T = x.right;

        x.right = y;
        y.left = T;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Малое левое вращение
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T = y.left;

        y.left = x;
        x.right = T;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Балансировка узла
    private Node balance(Node node) {
        updateHeight(node);

        int balance = balanceFactor(node);

        // Левое поддерево выше, чем правое
        if (balance > 1) {
            if (height(node.left.right) > height(node.left.left)) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        // Правое поддерево выше, чем левое
        if (balance < -1) {
            if (height(node.right.left) > height(node.right.right)) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }

    // Вставка ключа и значения в дерево
    private Node insert(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value; // Обновление значения для существующего ключа
            return node;
        }

        return balance(node);
    }

    // Вставка ключа и значения в дерево (внешний метод)
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    // Поиск узла с заданным ключом
    private Node search(Node node, K key) {
        if (node == null || key.equals(node.key)) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Поиск значения по ключу (внешний метод)
    public V search(K key) {
        Node resultNode = search(root, key);
        return (resultNode != null) ? resultNode.value : null;
    }

    // Удаление узла с заданным ключом из дерева
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            // Найден узел для удаления

            // Узел с одним или без детей
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;

                // Узел с одним ребенком
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // Узел без детей
                    node = temp;
                }
            } else {
                // Узел с двумя детьми
                Node temp = findMin(node.right);
                node.key = temp.key;
                node.value = temp.value;
                node.right = delete(node.right, temp.key);
            }
        }

        if (node == null) {
            return null;
        }

        return balance(node);
    }

    // Удаление узла с заданным ключом (внешний метод)
    public void delete(K key) {
        root = delete(root, key);
    }

    // Поиск узла с минимальным ключом
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Метод для обхода дерева в порядке "влево-корень-вправо"
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.key + ": " + node.value);
            inOrderTraversal(node.right);
        }
    }

    // Метод для обхода дерева влево-корень-вправо (внешний метод)
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    // Метод для получения высоты корня
    public int getRootHeight() {
        return height(root);
    }

    // Метод для получения балансового фактора корня
    public int getRootBalanceFactor() {
        return balanceFactor(root);
    }
}
