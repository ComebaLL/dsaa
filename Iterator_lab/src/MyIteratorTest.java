/* Kuvykin N.D CMC-21*/
// тесты для класса MyIterator
import static org.junit.Assert.*;
import org.junit.Test;

public class MyIteratorTest {

    @Test
    public void testEquals() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        MyIterator<Integer> iterator1 = new MyIterator<>(node1);
        MyIterator<Integer> iterator2 = new MyIterator<>(node1);
        MyIterator<Integer> iterator3 = new MyIterator<>(node2);

        assertTrue(iterator1.equals(iterator2));
        assertFalse(iterator1.equals(iterator3));
    }

    @Test
    public void testNotEquals() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        MyIterator<Integer> iterator1 = new MyIterator<>(node1);
        MyIterator<Integer> iterator2 = new MyIterator<>(node1);
        MyIterator<Integer> iterator3 = new MyIterator<>(node2);

        assertFalse(iterator1.notEquals(iterator2));
        assertTrue(iterator1.notEquals(iterator3));
    }

    @Test
    public void testData() {
        Node<Integer> node1 = new Node<>(1);

        MyIterator<Integer> iterator = new MyIterator<>(node1);

        assertEquals(Integer.valueOf(1), iterator.data());
    }

    @Test
    public void testNext() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        MyIterator<Integer> iterator = new MyIterator<>(node1);
        iterator.next();

        assertEquals(node2, iterator.getCurrentNode());
    }
}

