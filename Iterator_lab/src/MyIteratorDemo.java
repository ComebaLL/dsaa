public class MyIteratorDemo {
    public static void main(String[] args) {
        // Создаем узлы списка
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        // Связываем узлы, создавая связанный список: 1 -> 2 -> 3
        node1.next = node2;
        node2.next = node3;

        // Создаем связанный список
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(node1);

        // Получаем итератор, указывающий на начало списка
        MyIterator<Integer> iterator = linkedList.begin();

        // Итерируем по списку и выводим элементы
        while (!iterator.isEnd()) {
            System.out.println(iterator.data());
            iterator.next();
        }
    }
}





