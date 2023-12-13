/* Kuvykin N.D CMC-21*/
// тесты для класса MyIterator
import org.junit.Test;
import static org.junit.Assert.*;

public class MyIteratorTest {

    @Test
    public void testBegin() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Проверяем, что метод begin() устанавливает итератор на начало коллекции
        MyIterator.begin();
        assertEquals(1, (int)MyIterator.data());
    }

    @Test
    public void testEnd() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Проверяем, что метод end() устанавливает итератор на конец коллекции
        MyIterator.end();
        assertTrue(MyIterator.isEnd());
    }

    @Test
    public void testEquals() {
        // Создаем два итератора и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator1 = new MyIterator<>(data);
        MyIterator<Integer> MyIterator2 = new MyIterator<>(data);

        // Устанавливаем оба итератора в начало коллекции
        MyIterator1.begin();
        MyIterator2.begin();

        // Проверяем, что метод equals() корректно сравнивает два итератора
        assertTrue(MyIterator1.equals(MyIterator2));
    }

    @Test
    public void testNotEquals() {
        // Создаем два итератора и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator1 = new MyIterator<>(data);
        MyIterator<Integer> MyIterator2 = new MyIterator<>(data);

        // Устанавливаем один итератор в начало, а другой - в конец коллекции
        MyIterator1.begin();
        MyIterator2.end();

        // Проверяем, что метод notEquals() корректно сравнивает два итератора
        assertTrue(MyIterator1.notEquals(MyIterator2));
    }

    @Test
    public void testPreIncrement() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Используем метод preIncrement() и проверяем, что итератор перешел к следующему элементу
        MyIterator.preIncrement();
        assertEquals(2, (int)MyIterator.data());
    }

    @Test
    public void testPostIncrement() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Используем метод postIncrement() и проверяем, что итератор перешел к следующему элементу
        MyIterator.postIncrement();
        assertEquals(2, (int)MyIterator.data());
    }

    @Test
    public void testNext() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Используем метод next() и проверяем, что итератор перешел к следующему элементу
        MyIterator.next();
        assertEquals(2, (int)MyIterator.data());
    }

    @Test
    public void testReset() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Устанавливаем итератор в начало, перемещаемся к следующему элементу, затем сбрасываем его
        MyIterator.begin();
        MyIterator.next();
        MyIterator.reset();

        // Проверяем, что итератор вернулся в начало коллекции
        assertEquals(1, (int)MyIterator.data());
    }

    @Test
    public void testIsEnd() {
        // Создаем итератор и массив данных
        Integer[] data = {1, 2, 3, 4, 5};
        MyIterator<Integer> MyIterator = new MyIterator<>(data);

        // Устанавливаем итератор на конец коллекции
        MyIterator.end();

        // Проверяем, что метод isEnd() возвращает true
        assertTrue(MyIterator.isEnd());
    }
}
