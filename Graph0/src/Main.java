/* Kuvykin N.D CMC-21

 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Вставка вершин
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");

        // Вставка ребер
        graph.insertEdge("A", "B", 3);
        graph.insertEdge("B", "C", 5);


        // Получение смежных вершин
        List<String> neighbors = graph.getNeighbors("B");
        System.out.println("Neighbors of B: " + neighbors);

        // Получение веса ребра
        int weight = graph.getWeight("B", "C");
        System.out.println("Weight of edge (B, C): " + weight);

        // Создание и вывод матрицы смежности
        int[][] adjacencyMatrix = graph.createAdjacencyMatrix();
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }

        // Удаление вершины
        graph.deleteVertex("A");

        // Удаление ребра
        graph.deleteEdge("B", "C");


    }
}