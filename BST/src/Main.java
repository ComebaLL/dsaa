public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Вставляем значения в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        // обход дерева в порядке восхождения

        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(tree.getRoot());
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println(value);
        }


    }
}