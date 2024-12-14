public class graph {
    static class Edge {
        String destination;
        int weight;
        Edge next;

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
            this.next = null;
        }
    }

    static class Vertex {
        String name;
        Edge edges;
        boolean visited;
        int distance;
        Vertex next;

        Vertex(String name) {
            this.name = name;
            this.edges = null;
            this.visited = false;
            this.distance = Integer.MAX_VALUE;
            this.next = null;
        }
    }

    static class Graph {
        Vertex vertices;
        void addVertex(String name) {
            Vertex newVertex = new Vertex(name);
            if (vertices == null) {
                vertices = newVertex;
            } else {
                Vertex temp = vertices;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newVertex;
            }
        }

        void addEdge(String source, String destination, int weight) {
            Vertex src = findVertex(source);
            if (src != null) {
                Edge newEdge = new Edge(destination, weight);
                if (src.edges == null) {
                    src.edges = newEdge;
                } else {
                    Edge temp = src.edges;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newEdge;
                }
            }
        }

        Vertex findVertex(String name) {
            Vertex temp = vertices;
            while (temp != null) {
                if (temp.name.equals(name)) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

        void dijkstra(String start) {
            Vertex startVertex = findVertex(start);
            if (startVertex == null) return;

            startVertex.distance = 0;
            while (true) {
                Vertex current = findClosestUnvisited();
                if (current == null) break;

                current.visited = true;
                Edge edge = current.edges;
                while (edge != null) {
                    Vertex neighbor = findVertex(edge.destination);
                    if (!neighbor.visited) {
                        int newDistance = current.distance + edge.weight;
                        if (newDistance < neighbor.distance) {
                            neighbor.distance = newDistance;
                        }
                    }
                    edge = edge.next;
                }
            }
        }

        Vertex findClosestUnvisited() {
            Vertex temp = vertices;
            Vertex closest = null;
            int minDistance = Integer.MAX_VALUE;

            while (temp != null) {
                if (!temp.visited && temp.distance < minDistance) {
                    minDistance = temp.distance;
                    closest = temp;
                }
                temp = temp.next;
            }
            return closest;
        }

        //belum urut, nanti deh. bagian bioskop f nya masih cacat
        void printDistances(String start) {
            System.out.println("Jarak dari " + start + ":");
            Vertex temp = vertices;
            while (temp != null) {
                System.out.println("Ke " + temp.name + ": " + (temp.distance == Integer.MAX_VALUE ? "unreach" : temp.distance));
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("rumah1");
        graph.addVertex("bioskopA");
        graph.addVertex("bioskopB");
        graph.addVertex("bioskopC");
        graph.addVertex("bioskopD");
        graph.addVertex("bioskopE");
        graph.addVertex("bioskopF");
        graph.addVertex("rumah2");
        graph.addVertex("rumah3");

        graph.addEdge("rumah1", "bioskopB", 12);
        graph.addEdge("rumah1", "bioskopE", 9);
        graph.addEdge("bioskopB", "bioskopA", 9);
        graph.addEdge("bioskopB", "bioskopC", 12);
        graph.addEdge("bioskopA", "rumah3", 5);
        graph.addEdge("bioskopC", "bioskopA", 7);
        graph.addEdge("bioskopC", "bioskopD", 6);
        graph.addEdge("bioskopD", "rumah2", 11);
        graph.addEdge("bioskopF", "bioskopC", 9);
        graph.addEdge("bioskopF", "bioskopE", 15);
        graph.addEdge("bioskopF", "rumah2", 11);

        graph.dijkstra("rumah1");
        graph.printDistances("rumah1");
    }
}