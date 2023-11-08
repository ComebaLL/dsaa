/* @author Kuvykin N.D CMC-21
AVLTree
 */
public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        System.out.println("Вставляем элементы в AVL-дерево:");
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("Inorder traversal:");
        avlTree.inOrderTraversal();

        System.out.println("Проверка баланса дерева:");
        boolean isBalanced = avlTree.isBalanced();
        System.out.println("Дерево " + (isBalanced ? "сбалансировано" : "не сбалансировано"));
    }
}