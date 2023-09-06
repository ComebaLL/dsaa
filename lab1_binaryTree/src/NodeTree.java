/* class node tree */
/* @author Kuvykin Nikita */

class NodeTree {
    int data;
    NodeTree left;
    NodeTree right;

    // Конструктор для создания нового узла
    public NodeTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
