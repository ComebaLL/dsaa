import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        // Создаем дерево и добавляем узлы
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Вызываем метод depth для определения глубины дерева
        int treeDepth = tree.depth();

        // Ожидаемый результат - глубина дерева
        assertEquals(3, treeDepth);
    }

    // проверка метода на поиск min-элемента
    @Test
    public void testMinValue() {
        // Создаем дерево и добавляем узлы
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Вызываем метод minValue для поиска наименьшего элемента
        Integer minValue = tree.minValue(tree.root);

        // Ожидаемый результат - наименьший элемент в дереве
        assertEquals(Integer.valueOf(2), minValue);
    }

    // проверка метода превращение в массив на основе NLR
    @Test
    public void testToArrayInOrder() {
        // Создаем дерево и добавляем узлы
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Вызываем метод toArrayInOrder для преобразования в массив
        List<Integer> result = tree.toArrayInOrder();

        // Ожидаемый результат - массив значений в порядке инфиксного обхода (LNR)
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 8);

        assertEquals(expected, result);
    }

    // проверка метода увелечения значения каждого узла на еденицу
    @Test
    public void testIncrementTreeValues() {
        // Создаем дерево и добавляем узлы
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Вызываем метод incrementTreeValues для увеличения значений на единицу
        tree.incrementTreeValues();

        // Создаем ожидаемое дерево с увеличенными значениями
        BinaryTree<Integer> expectedTree = new BinaryTree<>();
        expectedTree.insert(6);
        expectedTree.insert(4);
        expectedTree.insert(8);
        expectedTree.insert(3);
        expectedTree.insert(5);
        expectedTree.insert(7);
        expectedTree.insert(9);

        // Сравниваем дерево с увеличенными значениями с ожидаемым деревом
        assertEquals(expectedTree.toArrayInOrder(), tree.toArrayInOrder());
    }

    // проверка на выражденное дерево
    @Test
    public void testDegenerateTree() {
        // Создаем вырожденное дерево, добавляя элементы в одну ветвь
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        // Ожидаем, что дерево будет вырожденным
        assertTrue(tree.isDegenerateTree());
    }

    @Test
    public void testNonDegenerateTree() {
        // Создаем не вырожденное дерево
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);

        // Ожидаем, что дерево не будет вырожденным
        assertFalse(tree.isDegenerateTree());
    }

    // Проверка на Complete Tree
    @Test
    public void testCompleteTree() {
        // Создаем завершенное дерево, добавляя элементы по уровням
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);

        // Ожидаем, что дерево будет завершенным
        assertTrue(tree.isCompleteTree());
    }

    @Test
    public void testNonCompleteTree() {
        // Создаем не завершенное дерево, пропуская элементы на нижних уровнях
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);

        // Ожидаем, что дерево не будет завершенным
        assertFalse(tree.isCompleteTree());
    }

    // Проверка на Perfect Tree
    @Test
    public void testPerfectTree() {
        // Создаем совершенное дерево, добавляя элементы по уровням
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Ожидаем, что дерево будет совершенным
        assertTrue(tree.isPerfectTree());
    }

    @Test
    public void testNonPerfectTree() {
        // Создаем не совершенное дерево, пропуская элементы на нижних уровнях
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);

        // Ожидаем, что дерево не будет совершенным
        assertFalse(tree.isPerfectTree());
    }



}
