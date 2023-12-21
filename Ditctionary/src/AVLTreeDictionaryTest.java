/* @author Kuvykin N.D CMC-21 тесты к классу словарь на основе AVL tree */
public class AVLTreeDictionaryTest {
    public static void main(String[] args) {
        AVLTreeDictionary<Integer, String> dictionary = new AVLTreeDictionary<>();

        // Тест вставки
        dictionary.insert(1, "One");
        dictionary.insert(2, "Two");
        dictionary.insert(3, "Three");

        System.out.println("In-Order Traversal after insertion:");
        dictionary.inOrderTraversal();

        System.out.println("Root Height: " + dictionary.getRootHeight());
        System.out.println("Root Balance Factor: " + dictionary.getRootBalanceFactor());

        // Тест поиска
        System.out.println("Search for key 2: " + dictionary.search(2));
        System.out.println("Search for key 4: " + dictionary.search(4));


        // Тест удаления
        dictionary.delete(2);

        System.out.println("In-Order Traversal after deleting key 2:");
        dictionary.inOrderTraversal();

        System.out.println("Root Height: " + dictionary.getRootHeight());
        System.out.println("Root Balance Factor: " + dictionary.getRootBalanceFactor());

        // Тест удаления корня
        dictionary.delete(1);

        System.out.println("In-Order Traversal after deleting key 1:");
        dictionary.inOrderTraversal();

        System.out.println("Root Height: " + dictionary.getRootHeight());
        System.out.println("Root Balance Factor: " + dictionary.getRootBalanceFactor());
    }
}
