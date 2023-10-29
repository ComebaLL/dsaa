import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // не явное использование итератора

        // Создаем коллекцию ArrayList
        ArrayList<String> collection = new ArrayList<>();

        // Заполняем коллекцию несколькими элементами
        collection.add("Элемент 1");
        collection.add("Элемент 2");
        collection.add("Элемент 3");
        collection.add("Элемент 4");

        // Создаем итератор для коллекции
        Iterator<String> iterator = collection.iterator();

        // не явное использование итератора
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

        }

        // явное использование итератора
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item + " ");
        }
    }
}


