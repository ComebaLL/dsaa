/* lab 1 binary tree*/
/* @author Kuvykin Nikita */
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Добавляем элементы в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Выводим изначальное дерево
        System.out.println("Изначальное дерево:");
        tree.inOrderTraversal(); // Выводим элементы в порядке возрастания
        System.out.println("\n");

        int nodeToDelete = 30;

        // Удаляем узел со значением 30 обычным способом
        tree.delete(nodeToDelete);


        // Выводим дерево после удаления
        System.out.println("Дерево после удаления узла со значением " + nodeToDelete + " обычным способом:");
        tree.inOrderTraversal();
        System.out.println("\n");

        /*
        // Восстанавливаем изначальное дерево
        tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Удаляем узел со значением 30 рекурсивным способом
        tree.deleteRec(nodeToDelete, 30);

        // Выводим дерево после удаления
        System.out.println("Дерево после удаления узла со значением " + nodeToDelete + " рекурсивным способом:");
        tree.inOrderTraversal();

         */
    }
}

/*           50
           /   \
          30    70
         / \   /  \
        20 40 60 80
 */