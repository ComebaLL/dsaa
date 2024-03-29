import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    // тест метода копирования; todo сделат ьфункции для проверки разных генераций деревьев
    @Test
    public void testCopyTree() {
        // Создаем исходное дерево
        BinaryTree<Integer> originalTree = new BinaryTree<>();
        originalTree.insert(5);
        originalTree.insert(3);
        originalTree.insert(7);

        // Копируем дерево
        BinaryTree<Integer> copiedTree = originalTree.copyTree();

        // Проверяем, что дерево было скопировано
        assertNotSame(originalTree, copiedTree); // Убеждаемся, что это разные объекты
        assertTrue(isTreeEqual(originalTree.root, copiedTree.root)); // Проверяем, что содержимое одинаково
    }

    // Тест для перфектного дерева
    @Test
    public void testCopyPerfectTree() {
        // Создаем исходное перфектное дерево
        BinaryTree<Integer> originalPerfectTree = new BinaryTree<>();
        originalPerfectTree.insert(10);
        originalPerfectTree.insert(5);
        originalPerfectTree.insert(15);
        originalPerfectTree.insert(3);
        originalPerfectTree.insert(7);
        originalPerfectTree.insert(12);
        originalPerfectTree.insert(20);

        // Копируем дерево
        BinaryTree<Integer> copiedPerfectTree = originalPerfectTree.copyTree();

        // Проверяем, что дерево было скопировано
        assertNotSame(originalPerfectTree, copiedPerfectTree); // Убеждаемся, что это разные объекты
        assertTrue(isTreeEqual(originalPerfectTree.root, copiedPerfectTree.root)); // Проверяем, что содержимое одинаково
    }

    // Тест для вырожденного дерева
    @Test
    public void testCopyDegenerateTree() {
        // Создаем исходное вырожденное дерево
        BinaryTree<Integer> originalDegenerateTree = new BinaryTree<>();
        originalDegenerateTree.insert(5);
        originalDegenerateTree.insert(6);
        originalDegenerateTree.insert(7);

        // Копируем дерево
        BinaryTree<Integer> copiedDegenerateTree = originalDegenerateTree.copyTree();

        // Проверяем, что дерево было скопировано
        assertNotSame(originalDegenerateTree, copiedDegenerateTree); // Убеждаемся, что это разные объекты
        assertTrue(isTreeEqual(originalDegenerateTree.root, copiedDegenerateTree.root)); // Проверяем, что содержимое одинаково
    }

    // Тест для завершенного дерева
    @Test
    public void testCopyCompleteTree() {
        // Создаем исходное завершенное дерево
        BinaryTree<Integer> originalCompleteTree = new BinaryTree<>();
        originalCompleteTree.insert(10);
        originalCompleteTree.insert(5);
        originalCompleteTree.insert(15);
        originalCompleteTree.insert(3);
        originalCompleteTree.insert(7);
        originalCompleteTree.insert(12);
        originalCompleteTree.insert(20);

        // Копируем дерево
        BinaryTree<Integer> copiedCompleteTree = originalCompleteTree.copyTree();

        // Проверяем, что дерево было скопировано
        assertNotSame(originalCompleteTree, copiedCompleteTree); // Убеждаемся, что это разные объекты
        assertTrue(isTreeEqual(originalCompleteTree.root, copiedCompleteTree.root)); // Проверяем, что содержимое одинаково
    }

    // Вспомогательный метод для проверки равенства двух деревьев
    private <T extends Comparable<T>> boolean isTreeEqual(NodeTree<T> node1, NodeTree<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data.equals(node2.data) &&
                isTreeEqual(node1.left, node2.left) &&
                isTreeEqual(node1.right, node2.right);
    }


}
