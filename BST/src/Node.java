/* Kuvykin N.D CMC-21 */
// Класс для представления узла бинарного дерева
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
