import java.util.List;

/* lab 1 binary tree*/
/* @author Kuvykin Nikita */
public class Main {
    public static void main(String[] args) {
                BinaryTree<Integer> intTree = new BinaryTree<>();

                intTree.insert(10);
                intTree.insert(5);
                intTree.insert(15);
                intTree.insert(3);
                intTree.insert(7);

                // Подсчет узлов в дереве
                System.out.println("Количество узлов в дереве: " + intTree.countNodes());
                // Подсчет глубины дерева
                System.out.println("Глубина дерева: " + intTree.depth());

                // Выводим изначальное дерево
                System.out.println("Изначальное дерево:");
                intTree.inOrderTraversal(); // Выводим элементы в порядке возрастания
                System.out.println("\n");

                int nodeToDelete = 5;

                // Удаляем узел со значением 30 обычным способом
                intTree.delete(nodeToDelete);


                // Выводим дерево после удаления
                System.out.println("Дерево после удаления узла со значением " + nodeToDelete + " обычным способом:");
                intTree.inOrderTraversal();
                System.out.println("\n");

                intTree.incrementTreeValues();


                List<Integer> result = intTree.toArrayInOrder();
                System.out.println("Массив на основе обхода LNR: " + result);


    }
}
