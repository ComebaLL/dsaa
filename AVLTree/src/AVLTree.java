/* @author Kuvykin N.D CMC-21
AVLTree class
 */
class AVLTree<U extends Comparable<U>> {

    class Node {
        U key;
        int height;
        Node left, right;

        public Node(U key) {
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
    private Node insert(Node node, U key) {
        if (node == null) {
            return new Node(key);
        }

        int compareResult = key.compareTo(node.key);

        if (compareResult < 0) {
            node.left = insert(node.left, key);
        } else if (compareResult > 0) {
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
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Вставка ключа в AVL-дерево
    public void insert(U key) {
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

    // Проверка сбалансированности дерева
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

    // Вспомогательный метод для нахождения узла с минимальным ключом в дереве
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Удаление узла с ключом key из дерева с корнем node
    private Node delete(Node node, U key) {
        if (node == null) {
            return node;
        }

        int compareResult = key.compareTo(node.key);

        // Рекурсивное удаление в поддеревьях
        if (compareResult < 0) {
            node.left = delete(node.left, key);
        } else if (compareResult > 0) {
            node.right = delete(node.right, key);
        } else {
            // Узел с одним или без детей
            if ((node.left == null) || (node.right == null)) {
                Node temp = null;
                if (temp == node.left) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }

                // Нет потомков
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // Один потомок
                    node = temp; // Копирование содержимого
                }
            } else {
                // Узел с двумя потомками
                Node temp = findMin(node.right); // Находим узел с минимальным ключом в правом поддереве
                node.key = temp.key; // Копируем значение минимального ключа
                node.right = delete(node.right, temp.key); // Удаляем узел с минимальным ключом
            }
        }

        // Если дерево состоит из одного узла, просто удаляем его
        if (node == null) {
            return node;
        }

        // Обновляем высоту текущего узла
        updateHeight(node);

        // Получаем баланс-фактор
        int balance = getBalance(node);

        // Проверка нарушения баланса и восстановление
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Удаление ключа из AVL-дерева
    public void delete(U key) {
        root = delete(root, key);
    }

    // Поиск значения в узле с ключом key в дереве с корнем node
    private Node search(Node node, U key) {
        if (node == null || key.equals(node.key)) {
            return node;
        }

        int compareResult = key.compareTo(node.key);

        // Рекурсивный поиск в поддеревьях
        if (compareResult < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Поиск значения в AVL-дереве
    public Node search(U key) {
        return search(root, key);
    }
}


