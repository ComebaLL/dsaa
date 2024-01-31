/* Kuvykin N.D CMC-21
    class Graph
 */
import java.io.*;
import java.util.*;

// Шаблонный класс, представляющий граф
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
    private Vertex<T> findVertex(T label) {
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

    // Обход в глубину
    public List<T> depthFirstSearch(T startLabel) {
        Vertex<T> startVertex = findVertex(startLabel);
        List<T> result = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        // Начало рекурсивного обхода в глубину
        depthFirstSearchRecursive(startVertex, visited, result);

        return result;
    }

    // Рекурсивный обход в глубину
    private void depthFirstSearchRecursive(Vertex<T> vertex, Set<Vertex<T>> visited, List<T> result) {
        // Проверка наличия вершины и её посещения
        if (vertex != null && !visited.contains(vertex)) {
            // Посещение вершины
            visited.add(vertex);
            result.add(vertex.label);

            // Рекурсивный вызов для всех соседей текущей вершины
            for (T neighborLabel : getNeighbors(vertex.label)) {
                Vertex<T> neighbor = findVertex(neighborLabel);
                depthFirstSearchRecursive(neighbor, visited, result);
            }
        }
    }

    // Обход в ширину
    public List<T> breadthFirstSearch(T startLabel) {
        Vertex<T> startVertex = findVertex(startLabel);
        List<T> result = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();

        // Начальная вершина помечается посещенной и добавляется в очередь
        visited.add(startVertex);
        queue.add(startVertex);

        // Цикл, пока очередь не пуста
        while (!queue.isEmpty()) {
            // Извлечение вершины из очереди
            Vertex<T> currentVertex = queue.poll();
            result.add(currentVertex.label);

            // Перебор соседей текущей вершины
            for (T neighborLabel : getNeighbors(currentVertex.label)) {
                Vertex<T> neighbor = findVertex(neighborLabel);

                // Если сосед еще не посещен, помечаем его и добавляем в очередь
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    // путь- поиск кратчайшег опути; файл- запиьс и чтение графа из файла

    // Метод для поиска кратчайшего пути в графе с использованием алгоритма Дейкстры
    public List<T> shortestPath(T startLabel, T endLabel) {
        Vertex<T> startVertex = findVertex(startLabel);
        Vertex<T> endVertex = findVertex(endLabel);

        // Проверка наличия начальной и конечной вершин
        if (startVertex == null || endVertex == null) {
            return Collections.emptyList();
        }

        // Инициализация таблицы расстояний и очереди с приоритетом
        Map<Vertex<T>, Integer> distances = new HashMap<>();
        PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Инициализация таблицы предшествующих вершин
        Map<Vertex<T>, Vertex<T>> predecessors = new HashMap<>();

        // Начальная вершина имеет расстояние 0, остальные - бесконечность
        distances.put(startVertex, 0);
        for (Vertex<T> vertex : vertices) {
            if (vertex != startVertex) {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            priorityQueue.add(vertex);
        }

        // Основной цикл алгоритма
        while (!priorityQueue.isEmpty()) {
            Vertex<T> currentVertex = priorityQueue.poll();

            for (T neighborLabel : getNeighbors(currentVertex.label)) {
                Vertex<T> neighbor = findVertex(neighborLabel);

                int newDistance = distances.get(currentVertex) + getWeight(currentVertex.label, neighbor.label);
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    predecessors.put(neighbor, currentVertex);

                    // Обновление приоритетов в очереди с приоритетом
                    priorityQueue.remove(neighbor);
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Восстановление пути
        List<T> path = new ArrayList<>();
        Vertex<T> current = endVertex;
        while (current != null) {
            path.add(current.label);
            current = predecessors.get(current);
        }

        // Переворачиваем список, чтобы путь был от начала к концу
        Collections.reverse(path);

        return path;
    }

    // Метод для записи графа в текстовый файл
    public void saveToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Сохранение вершин
            for (Vertex<T> vertex : vertices) {
                writer.println(vertex.label);
            }

            // Сохранение ребер
            for (Edge<T> edge : edges) {
                writer.println(edge.start.label + " " + edge.end.label + " " + edge.weight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения графа из текстового файла
    public void loadFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Очистка текущего графа
            vertices.clear();
            edges.clear();

            // Чтение вершин
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    break;
                }
                insertVertex((T) line);
            }

            // Чтение ребер
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    break;
                }
                String[] parts = line.split(" ");
                T startLabel = (T) parts[0];
                T endLabel = (T) parts[1];
                int weight = Integer.parseInt(parts[2]);
                insertEdge(startLabel, endLabel, weight);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения множества вершин
    public Set<Vertex<T>> getVertices() {
        return vertices;
    }
}


