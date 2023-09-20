/* class node tree */
/* @author Kuvykin Nikita */

class NodeTree<T> {
    T data;
    NodeTree<T> left;
    NodeTree<T> right;

    // Конструктор для создания нового узла
    public NodeTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

