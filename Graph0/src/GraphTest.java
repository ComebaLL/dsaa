import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testGraphOperations() {
        // Создание графа
        Graph graph = new Graph();

        // Вставка вершин
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");

        // Проверка наличия вершин в графе
        assertTrue(graph.getNeighbors("A").isEmpty());
        assertTrue(graph.getNeighbors("B").isEmpty());
        assertTrue(graph.getNeighbors("C").isEmpty());

        // Вставка ребер
        graph.insertEdge("A", "B", 3);
        graph.insertEdge("B", "C", 5);

        // Проверка наличия ребер в графе
        assertEquals(3, graph.getWeight("A", "B"));
        assertEquals(5, graph.getWeight("B", "C"));

        // Получение смежных вершин
        assertEquals(1, graph.getNeighbors("A").size());
        assertEquals(2, graph.getNeighbors("B").size());
        assertEquals(1, graph.getNeighbors("C").size());

        // Удаление вершины
        graph.deleteVertex("A");

        // Проверка удаления вершины и связанных с ней ребер
        assertTrue(graph.getNeighbors("A").isEmpty());
        assertNull(graph.findVertex("A"));

        // Удаление ребра
        graph.deleteEdge("B", "C");

        // Проверка удаления ребра
        assertEquals(0, graph.getWeight("B", "C"));

        // Создание матрицы смежности
        int[][] adjacencyMatrix = graph.createAdjacencyMatrix();

        // Проверка размера матрицы смежности
        assertEquals(2, adjacencyMatrix.length);
        assertEquals(2, adjacencyMatrix[0].length);
        assertEquals(2, adjacencyMatrix[1].length);

        // Проверка значений матрицы смежности
        assertEquals(0, adjacencyMatrix[0][1]);
        assertEquals(0, adjacencyMatrix[1][0]);
    }
}

