/* Kuvykin N.D CMC-21
    class Graph
 */
import java.util.*;

// Класс, представляющий граф
public class Graph {
    // Множество вершин
    private Set<Vertex> vertices;
    // Множество ребер
    private Set<Edge> edges;

    // Конструктор
    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }

    // Внутренний класс, представляющий вершину
    private class Vertex {
        private String label; // Метка вершины

        public Vertex(String label) {
            this.label = label;
        }
    }

    // Внутренний класс, представляющий ребро
    private class Edge {
        private Vertex start; // Начальная вершина
        private Vertex end;   // Конечная вершина
        private int weight;    // Вес ребра

        public Edge(Vertex start, Vertex end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    // Вставка новой вершины
    public void insertVertex(String label) {
        Vertex newVertex = new Vertex(label);
        vertices.add(newVertex);
    }

    // Вставка нового ребра
    public void insertEdge(String startLabel, String endLabel, int weight) {
        Vertex startVertex = findVertex(startLabel);
        Vertex endVertex = findVertex(endLabel);

        if (startVertex != null && endVertex != null && !hasEdge(startVertex, endVertex)) {
            Edge newEdge = new Edge(startVertex, endVertex, weight);
            edges.add(newEdge);
        }
    }

    // Удаление вершины
    public void deleteVertex(String label) {
        Vertex vertexToRemove = findVertex(label);

        if (vertexToRemove != null) {
            vertices.remove(vertexToRemove);
            edges.removeIf(edge -> edge.start == vertexToRemove || edge.end == vertexToRemove);
        }
    }

    // Удаление ребра
    public void deleteEdge(String startLabel, String endLabel) {
        Vertex startVertex = findVertex(startLabel);
        Vertex endVertex = findVertex(endLabel);

        edges.removeIf(edge -> edge.start == startVertex && edge.end == endVertex);
    }

    // Получение смежных вершин
    public List<String> getNeighbors(String label) {
        Vertex vertex = findVertex(label);
        List<String> neighbors = new ArrayList<>();

        if (vertex != null) {
            for (Edge edge : edges) {
                if (edge.start == vertex) {
                    neighbors.add(edge.end.label);
                } else if (edge.end == vertex) {
                    neighbors.add(edge.start.label);
                }
            }
        }

        return neighbors;
    }

    // Получение веса ребра
    public int getWeight(String startLabel, String endLabel) {
        Vertex startVertex = findVertex(startLabel);
        Vertex endVertex = findVertex(endLabel);

        for (Edge edge : edges) {
            if ((edge.start == startVertex && edge.end == endVertex) || (edge.start == endVertex && edge.end == startVertex)) {
                return edge.weight;
            }
        }

        return 0;
    }

    // Создание матрицы смежности
    public int[][] createAdjacencyMatrix() {
        int size = vertices.size();
        int[][] adjacencyMatrix = new int[size][size];

        // Заполняем матрицу нулями
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        // Заполняем матрицу значениями весов ребер
        for (Edge edge : edges) {
            int i = getIndex(edge.start);
            int j = getIndex(edge.end);
            adjacencyMatrix[i][j] = edge.weight;
            adjacencyMatrix[j][i] = edge.weight; // для неориентированного графа
        }

        return adjacencyMatrix;
    }

    // Вспомогательный метод для поиска вершины по метке
    protected Vertex findVertex(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    // Вспомогательный метод для получения индекса вершины в матрице
    private int getIndex(Vertex vertex) {
        int i = 0;
        for (Vertex v : vertices) {
            if (v == vertex) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // Вспомогательный метод для проверки наличия ребра между двумя вершинами
    private boolean hasEdge(Vertex start, Vertex end) {
        for (Edge edge : edges) {
            if ((edge.start == start && edge.end == end) || (edge.start == end && edge.end == start)) {
                return true;
            }
        }
        return false;
    }



}


