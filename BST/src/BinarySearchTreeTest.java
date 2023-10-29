/* Kuvykin N.D CMC-21*/
// Tests for class BinarySearchTree
import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        // Создаем бинарное дерево поиска
        BinarySearchTree tree = new BinarySearchTree();

        // Вставляем значения в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        // Проверяем, что значения были успешно вставлены и могут быть найдены
        assertTrue(tree.search(50));
        assertTrue(tree.search(30));
        assertTrue(tree.search(70));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
    }

    @Test
    public void testDelete() {
        // Создаем бинарное дерево поиска
        BinarySearchTree tree = new BinarySearchTree();

        // Вставляем значения в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        // Удаляем значение из дерева
        tree.delete(30);

        // Проверяем, что удаленное значение больше не существует, а другие остались
        assertTrue(tree.search(50));
        assertFalse(tree.search(30));
        assertTrue(tree.search(70));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
    }

    @Test
    public void testSearch() {
        // Создаем бинарное дерево поиска
        BinarySearchTree tree = new BinarySearchTree();

        // Вставляем значения в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        // Проверяем, что значения, которые мы добавили, могут быть найдены,
        // и значения, которые мы не добавляли, не могут быть найдены
        assertTrue(tree.search(50));
        assertTrue(tree.search(30));
        assertTrue(tree.search(70));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));

        assertFalse(tree.search(10));
        assertFalse(tree.search(60));
    }
}

