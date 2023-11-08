/* @author Kuvykin N.D CMC-21
AVLTree class test
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class AVLTreeTest {

    // Тест для проверки высоты узла
    @Test
    public void testHeight() {
        // Создаем экземпляр AVLTree
        AVLTree avlTree = new AVLTree();

        // Создаем узлы дерева
        AVLTree.Node node1 = avlTree.new Node(10);
        AVLTree.Node node2 = avlTree.new Node(20);
        AVLTree.Node node3 = avlTree.new Node(30);
        AVLTree.Node node4 = avlTree.new Node(40);

        // Строим дерево
        node1.left = node2;
        node2.right = node3;
        node3.right = node4;

        // Пересчитываем высоту узлов
        avlTree.height(node1);
        avlTree.height(node2);
        avlTree.height(node3);
        avlTree.height(node4);

        assertEquals(4, node1.height); // Ожидаемая высота узла node1
        assertEquals(3, node2.height); // Ожидаемая высота узла node2
        assertEquals(2, node3.height); // Ожидаемая высота узла node3
        assertEquals(1, node4.height); // Ожидаемая высота узла node4
    }



    @Test
    public void testGetBalance() {
        // Создаем экземпляр AVLTree
        AVLTree avlTree = new AVLTree();

        // Создаем узлы дерева
        AVLTree.Node node1 = avlTree.new Node(10);
        AVLTree.Node node2 = avlTree.new Node(20);
        AVLTree.Node node3 = avlTree.new Node(30);
        AVLTree.Node node4 = avlTree.new Node(40);

        // Строим дерево
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        // Проверяем баланс-фактор узлов
        assertEquals(-1, avlTree.getBalance(node1)); // Ожидаемый баланс-фактор узла node1
        assertEquals(0, avlTree.getBalance(node2)); // Ожидаемый баланс-фактор узла node2
        assertEquals(1, avlTree.getBalance(node3)); // Ожидаемый баланс-фактор узла node3
        assertEquals(0, avlTree.getBalance(node4)); // Ожидаемый баланс-фактор узла node4
    }




    // Тест для проверки райт ротейшн
    @Test
    public void testRightRotate() {
        AVLTree avlTree = new AVLTree();
        AVLTree.Node node1 = avlTree.new Node(10);
        AVLTree.Node node2 = avlTree.new Node(20);
        AVLTree.Node node3 = avlTree.new Node(30);

        node1.left = node2;
        node2.right = node3;

        AVLTree.Node newRoot = avlTree.rightRotate(node1);

        // Проверяем, что после правого поворота, новый корень и дочерние узлы находятся на своих местах
        assertEquals(node2, newRoot); // Ожидаемый новый корень
        assertEquals(node1, newRoot.right); // Ожидаемый правый дочерний узел
        assertEquals(node3, newRoot.right.left); // Ожидаемый левый дочерний узел правого дочернего узла
        assertNull(newRoot.left); // Левый дочерний узел нового корня должен быть null
    }


    // Тест для проверки лефт ротейшн
    @Test
    public void testLeftRotate() {
        AVLTree avlTree = new AVLTree();
        AVLTree.Node node1 = avlTree.new Node(10);
        AVLTree.Node node2 = avlTree.new Node(20);
        AVLTree.Node node3 = avlTree.new Node(30);

        node1.right = node2;
        node2.left = node3;

        AVLTree.Node newRoot = avlTree.leftRotate(node1);

        // Проверяем, что после левого поворота, новый корень и дочерние узлы находятся на своих местах
        assertEquals(node2, newRoot); // Ожидаемый новый корень
        assertEquals(node1, newRoot.left); // Ожидаемый левый дочерний узел
        assertEquals(node3, newRoot.left.right); // Ожидаемый правый дочерний узел левого дочернего узла
        assertNull(newRoot.right); // Правый дочерний узел нового корня должен быть null
    }



    // Тест вставки узла в дерево
    @Test
    public void testInsert() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(5);
        avlTree.insert(25);

        // Проверяем, что элементы были вставлены в правильном порядке
        assertEquals(10, avlTree.root.key); // Ожидаемый корень
        assertEquals(5, avlTree.root.left.key); // Ожидаемый левый дочерний узел
        assertEquals(20, avlTree.root.right.key); // Ожидаемый правый дочерний узел
        assertEquals(25, avlTree.root.right.right.key); // Ожидаемый правый дочерний узел правого дочернего узла
    }
}

