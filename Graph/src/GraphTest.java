/* тесты класса Graph
    Kuvykin N.D CMC-21
 */

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GraphTest {

    // Тест для вставки вершины
    @Test
    public void testInsertVertex() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершину
        graph.insertVertex("A");

        // Проверяем наличие вершины в графе
        assertTrue(graph.getNeighbors("A").isEmpty());
    }

    // Тест для вставки ребра
    @Test
    public void testInsertEdge() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины
        graph.insertVertex("A");
        graph.insertVertex("B");

        // Вставляем ребро
        graph.insertEdge("A", "B", 2);

        // Проверяем наличие ребра в графе
        assertEquals(2, graph.getWeight("A", "B"));
    }

    // Тест для удаления вершины
    @Test
    public void testDeleteVertex() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершину
        graph.insertVertex("A");

        // Удаляем вершину
        graph.deleteVertex("A");

        // Проверяем отсутствие вершины в графе
        assertTrue(graph.getNeighbors("A").isEmpty());
    }

    // Тест для удаления ребра
    @Test
    public void testDeleteEdge() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины и ребро
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertEdge("A", "B", 2);

        // Удаляем ребро
        graph.deleteEdge("A", "B");

        // Проверяем отсутствие ребра в графе
        assertEquals(0, graph.getWeight("A", "B"));
    }

    // Тест для обхода в глубину
    @Test
    public void testDepthFirstSearch() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины и ребра
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B", 2);
        graph.insertEdge("B", "C", 1);

        // Получаем результат обхода в глубину
        List<String> result = graph.depthFirstSearch("A");

        // Проверяем правильность порядка вершин
        assertArrayEquals(new String[]{"A", "B", "C"}, result.toArray());
    }

    // Тест для обхода в ширину
    @Test
    public void testBreadthFirstSearch() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины и ребра
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B", 2);
        graph.insertEdge("B", "C", 1);

        // Получаем результат обхода в ширину
        List<String> result = graph.breadthFirstSearch("A");

        // Проверяем правильность порядка вершин
        assertArrayEquals(new String[]{"A", "B", "C"}, result.toArray());
    }

    // Тест для получения смежных вершин
    @Test
    public void testGetNeighbors() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины и ребра
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B", 2);
        graph.insertEdge("B", "C", 1);

        // Получаем смежные вершины
        List<String> neighborsA = graph.getNeighbors("A");
        List<String> neighborsB = graph.getNeighbors("B");
        List<String> neighborsC = graph.getNeighbors("C");

        // Проверяем правильность полученных смежных вершин
        assertArrayEquals(new String[]{"B"}, neighborsA.toArray());
        assertArrayEquals(new String[]{"A", "C"}, neighborsB.toArray());
        assertArrayEquals(new String[]{"B"}, neighborsC.toArray());
    }

    // Тест для получения веса ребра
    @Test
    public void testGetWeight() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины и ребра
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B", 2);
        graph.insertEdge("B", "C", 1);

        // Получаем вес ребер
        int weightAB = graph.getWeight("A", "B");
        int weightBC = graph.getWeight("B", "C");
        int weightAC = graph.getWeight("A", "C");

        // Проверяем правильность полученных весов ребер
        assertEquals(2, weightAB);
        assertEquals(1, weightBC);
        assertEquals(0, weightAC); // Нет ребра между A и C, ожидаем 0
    }

    // Тест для создания матрицы смежности
    @Test
    public void testCreateAdjacencyMatrix() {
        Graph<String> graph = new Graph<>();

        // Вставляем вершины и ребра
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B", 2);
        graph.insertEdge("B", "C", 1);

        // Создаем матрицу смежности
        int[][] adjacencyMatrix = graph.createAdjacencyMatrix();

        // Проверяем правильность созданной матрицы смежности
        int size = graph.getVertices().size(); // Используем getVertices() вместо getNeighbors()
        assertEquals(0, adjacencyMatrix[0][0]); // A -> A
        assertEquals(2, adjacencyMatrix[0][1]); // A -> B
        assertEquals(0, adjacencyMatrix[0][2]); // A -> C
        assertEquals(2, adjacencyMatrix[1][0]); // B -> A
        assertEquals(0, adjacencyMatrix[1][1]); // B -> B
        assertEquals(1, adjacencyMatrix[1][2]); // B -> C
        assertEquals(0, adjacencyMatrix[2][0]); // C -> A
        assertEquals(1, adjacencyMatrix[2][1]); // C -> B
        assertEquals(0, adjacencyMatrix[2][2]); // C -> C
    }

    // Тест для метода : алгоритм Дейкстры
    @Test
    public void testShortestPath() {
        Graph<Integer> graph = new Graph<>();
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 3);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(2, 4, 4);
        graph.insertEdge(3, 4, 1);

        // Вызов метода shortestPath
        List<Integer> path = graph.shortestPath(1, 4);

        // Ожидаемый результат: путь 1 -> 2 -> 3 -> 4
        List<Integer> expectedPath = Arrays.asList(1, 2, 3, 4);

        // Проверка, что результат совпадает с ожидаемым путем
        assertEquals(expectedPath, path);
    }

}

