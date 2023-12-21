/* Kuvykin N.D CMC-21
    class Graph
 */
import java.util.*;

// Класс, представляющий граф
public class Graph<T> {
    // Множество вершин
    private Set<Vertex<T>> vertices;
    // Множество ребер
    private Set<Edge<T>> edges;

    // Конструктор
    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }

    // Внутренний класс, представляющий вершину
    private class Vertex<T> {
        private T label; // Метка вершины

        public Vertex(T label) {
            this.label = label;
        }
    }

    // Внутренний класс, представляющий ребро
    private class Edge<T> {
        private Vertex<T> start; // Начальная вершина
        private Vertex<T> end;   // Конечная вершина
        private int weight;    // Вес ребра

        public Edge(Vertex<T> start, Vertex<T> end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    // Вставка новой вершины
    public void insertVertex(T label) {
        Vertex<T> newVertex = new Vertex<>(label);
        vertices.add(newVertex);
    }

    // Вставка нового ребра
    public void insertEdge(T startLabel, T endLabel, int weight) {
        Vertex<T> startVertex = findVertex(startLabel);
        Vertex<T> endVertex = findVertex(endLabel);

        if (startVertex != null && endVertex != null && !hasEdge(startVertex, endVertex)) {
            Edge<T> newEdge = new Edge<>(startVertex, endVertex, weight);
            edges.add(newEdge);
        }
    }

    // Удаление вершины
    public void deleteVertex(T label) {
        Vertex<T> vertexToRemove = findVertex(label);

        if (vertexToRemove != null) {
            vertices.remove(vertexToRemove);
            edges.removeIf(edge -> edge.start == vertexToRemove || edge.end == vertexToRemove);
        }
    }

    // Удаление ребра
    public void deleteEdge(T startLabel, T endLabel) {
        Vertex<T> startVertex = findVertex(startLabel);
        Vertex<T> endVertex = findVertex(endLabel);

        edges.removeIf(edge -> edge.start == startVertex && edge.end == endVertex);
    }

    // Получение смежных вершин
    public List<T> getNeighbors(T label) {
        Vertex<T> vertex = findVertex(label);
        List<T> neighbors = new ArrayList<>();

        if (vertex != null) {
            for (Edge<T> edge : edges) {
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
    public int getWeight(T startLabel, T endLabel) {
        Vertex<T> startVertex = findVertex(startLabel);
        Vertex<T> endVertex = findVertex(endLabel);

        for (Edge<T> edge : edges) {
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
        for (Edge<T> edge : edges) {
            int i = getIndex(edge.start);
            int j = getIndex(edge.end);
            adjacencyMatrix[i][j] = edge.weight;
            adjacencyMatrix[j][i] = edge.weight; // для неориентированного графа
        }

        return adjacencyMatrix;
    }

    // Вспомогательный метод для поиска вершины по метке
    protected Vertex<T> findVertex(T label) {
        for (Vertex<T> vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    // Вспомогательный метод для получения индекса вершины в матрице
    private int getIndex(Vertex<T> vertex) {
        int i = 0;
        for (Vertex<T> v : vertices) {
            if (v == vertex) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // Вспомогательный метод для проверки наличия ребра между двумя вершинами
    private boolean hasEdge(Vertex<T> start, Vertex<T> end) {
        for (Edge<T> edge : edges) {
            if ((edge.start == start && edge.end == end) || (edge.start == end && edge.end == start)) {
                return true;
            }
        }
        return false;
    }

    // Обход графа в ширину 
    public List<T> bfs(T startLabel) {
        List<T> result = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();

        Vertex<T> startVertex = findVertex(startLabel);

        if (startVertex == null) {
            return result; // Вершина не найдена
        }

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();
            result.add(currentVertex.label);

            for (T neighborLabel : getNeighbors(currentVertex.label)) {
                Vertex<T> neighborVertex = findVertex(neighborLabel);

                if (neighborVertex != null && !visited.contains(neighborVertex)) {
                    queue.add(neighborVertex);
                    visited.add(neighborVertex);
                }
            }
        }

        return result;
    }
}



