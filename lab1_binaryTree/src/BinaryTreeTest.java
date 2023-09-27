import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/* класс для теста методов класса BinaryTree */
/* @author Kuvykin Nikita */
public class BinaryTreeTest {
    private BinaryTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BinaryTree<>();
    }

    // проверка метода insert
    @Test
    public void testInsert() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
    }

    // проверка метода delete узла
    @Test
    public void testDelete() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        assertTrue(tree.contains(5));
        tree.delete(5);
        assertFalse(tree.contains(5));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
    }

    // проверка обхода LNR
    @Test
    public void testInOrderTraversal() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

    }

    // проверка подсчета кол-во узлов в дереве
    @Test
    public void testCountNodes() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        assertEquals(7, tree.countNodes());
    }

    // проверка метода подсчета глубины дерева
    @Test
    public void testDepth() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        assertEquals(3, tree.depth());
    }


}
