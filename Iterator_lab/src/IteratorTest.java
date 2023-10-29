/* Kuvykin N.D CMC-21*/
// тесты для класса Iterator
import org.junit.Test;
import static org.junit.Assert.*;

public class IteratorTest {

    @Test
    public void testBegin() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Проверяем, что метод begin() устанавливает итератор на начало коллекции
        iterator.begin();
        assertEquals(1, (int)iterator.data());
    }

    @Test
    public void testEnd() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Проверяем, что метод end() устанавливает итератор на конец коллекции
        iterator.end();
        assertTrue(iterator.isEnd());
    }

    @Test
    public void testEquals() {
        // Создаем два итератора и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator1 = new Iterator<>(data);
        Iterator<Integer> iterator2 = new Iterator<>(data);

        // Устанавливаем оба итератора в начало коллекции
        iterator1.begin();
        iterator2.begin();

        // Проверяем, что метод equals() корректно сравнивает два итератора
        assertTrue(iterator1.equals(iterator2));
    }

    @Test
    public void testNotEquals() {
        // Создаем два итератора и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator1 = new Iterator<>(data);
        Iterator<Integer> iterator2 = new Iterator<>(data);

        // Устанавливаем один итератор в начало, а другой - в конец коллекции
        iterator1.begin();
        iterator2.end();

        // Проверяем, что метод notEquals() корректно сравнивает два итератора
        assertTrue(iterator1.notEquals(iterator2));
    }

    @Test
    public void testPreIncrement() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Используем метод preIncrement() и проверяем, что итератор перешел к следующему элементу
        iterator.preIncrement();
        assertEquals(2, (int)iterator.data());
    }

    @Test
    public void testPostIncrement() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Используем метод postIncrement() и проверяем, что итератор перешел к следующему элементу
        iterator.postIncrement();
        assertEquals(2, (int)iterator.data());
    }

    @Test
    public void testNext() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Используем метод next() и проверяем, что итератор перешел к следующему элементу
        iterator.next();
        assertEquals(2, (int)iterator.data());
    }

    @Test
    public void testReset() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Устанавливаем итератор в начало, перемещаемся к следующему элементу, затем сбрасываем его
        iterator.begin();
        iterator.next();
        iterator.reset();

        // Проверяем, что итератор вернулся в начало коллекции
        assertEquals(1, (int)iterator.data());
    }

    @Test
    public void testIsEnd() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        Iterator<Integer> iterator = new Iterator<>(data);

        // Устанавливаем итератор на конец коллекции
        iterator.end();

        // Проверяем, что метод isEnd() возвращает true
        assertTrue(iterator.isEnd());
    }
}
