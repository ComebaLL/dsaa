public class MyIteratorDemo {
    public static void main(String[] args) {
        // Создаем массив строк
        String[] dataArray = {"A", "B", "C", "D", "E"};

        // Создаем объект MyIterator для массива строк
        MyIterator<String> myIterator = new MyIterator<>(dataArray);

        // До вызова методов
        System.out.println("Before Methods:");
        printIteratorInfo(myIterator);

        // Применение методов класса MyIterator
        myIterator.begin();
        printIteratorInfo(myIterator);

        myIterator.next();
        printIteratorInfo(myIterator);

        myIterator.preIncrement();
        printIteratorInfo(myIterator);

        myIterator.postIncrement();
        printIteratorInfo(myIterator);

        myIterator.reset();
        printIteratorInfo(myIterator);

        myIterator.end();
        printIteratorInfo(myIterator);
    }

    // Вспомогательный метод для вывода информации о состоянии итератора
    private static <T> void printIteratorInfo(MyIterator<T> myIterator) {
        System.out.println("Current Element: " + myIterator.data());
        System.out.println("Is End: " + myIterator.isEnd());
        System.out.println();
    }
}





