import java.util.Scanner;

class Graph {
    class Node {
        String vertex;
        int weight;
        Node next;

        Node(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = null;
        }
    }

    class LinkedList {
        Node head;

        void add(String vertex, int weight) {
            Node newNode = new Node(vertex, weight);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        Node getHead() {
            return head;
        }
    }

    class Vertex {
        String name;
        int distance;
        boolean visited;
        String previous;
        Vertex next;
        LinkedList neighbors;

        Vertex(String name) {
            this.name = name;
            this.distance = Integer.MAX_VALUE;
            this.visited = false;
            this.previous = null;
            this.next = null;
            this.neighbors = new LinkedList();
        }
    }

    Vertex vertexListHead;

    Graph() {
        vertexListHead = null;
    }

    void addVertex(String name) {
        Vertex newVertex = new Vertex(name);
        if (vertexListHead == null) {
            vertexListHead = newVertex;
        } else {
            Vertex temp = vertexListHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVertex;
        }
    }

    void addEdge(String src, String dest, int weight) {
        Vertex srcVertex = getVertex(src);
        if (srcVertex != null) {
            srcVertex.neighbors.add(dest, weight);
        }
    }

    Vertex getVertex(String name) {
        Vertex temp = vertexListHead;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    Vertex findMinVertex() {
        Vertex minVertex = null;
        int minDistance = Integer.MAX_VALUE;

        Vertex temp = vertexListHead;
        while (temp != null) {
            if (!temp.visited && temp.distance < minDistance) {
                minDistance = temp.distance;
                minVertex = temp;
            }
            temp = temp.next;
        }

        return minVertex;
    }

    void dijkstra(String start) {
        Vertex startVertex = getVertex(start);
        startVertex.distance = 0;

        while (true) {
            Vertex current = findMinVertex();
            if (current == null) {
                break;
            }

            current.visited = true;

            Node neighborNode = current.neighbors.getHead();
            while (neighborNode != null) {
                Vertex neighbor = getVertex(neighborNode.vertex);
                if (neighbor != null && !neighbor.visited) {
                    int newDist = current.distance + neighborNode.weight;
                    if (newDist < neighbor.distance) {
                        neighbor.distance = newDist;
                        neighbor.previous = current.name;
                    }
                }
                neighborNode = neighborNode.next;
            }
        }

        printResults(start);
    }

    void printResults(String start) {
        System.out.println("Vertex  \tDistance from " + start + "\t\tPrevious");

        Vertex resultListHead = null;
        Vertex temp = vertexListHead;
        while (temp != null) {
            Vertex newVertex = new Vertex(temp.name);
            newVertex.distance = temp.distance;
            newVertex.previous = temp.previous;
            newVertex.visited = temp.visited;
            newVertex.neighbors = temp.neighbors;

            if (resultListHead == null) {
                resultListHead = newVertex;
            } else {
                Vertex last = resultListHead;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newVertex;
            }
            temp = temp.next;
        }

        while (resultListHead != null) {
            Vertex minVertex = null;
            Vertex minPrev = null;
            int minDistance = Integer.MAX_VALUE;

            Vertex current = resultListHead;
            Vertex prev = null;
            while (current != null) {
                if (current.distance < minDistance) {
                    minDistance = current.distance;
                    minVertex = current;
                    minPrev = prev;
                }
                prev = current;
                current = current.next;
            }

            if (minVertex != null) {
                System.out.println(
                    minVertex.name + "  \t" +
                    (minVertex.distance == Integer.MAX_VALUE ? "Infinity" : minVertex.distance) + "Km" + "\t\t\t\t" +
                    (minVertex.previous != null ? minVertex.previous : "None")
                );

                if (minPrev == null) { 
                    resultListHead = minVertex.next;
                } else {
                    minPrev.next = minVertex.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("rumah1");
        graph.addVertex("bioskopB");
        graph.addVertex("bioskopA");
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
        graph.addEdge("bioskopC", "bioskopD", 6);
        graph.addEdge("bioskopE", "bioskopF", 15);
        graph.addEdge("bioskopF", "rumah2", 11);

        Scanner scanner = new Scanner(System.in);
        String startVertex;

        while (true) {
            System.out.print("Pilih simpul awal (rumah1, rumah2, rumah3): ");
            startVertex = scanner.nextLine().trim();

            if (startVertex.equals("rumah1") || startVertex.equals("rumah2") || startVertex.equals("rumah3")) {
                break;
            } else {
                System.out.println("Input tidak valid. Silakan pilih antara rumah1, rumah2, atau rumah3.");
            }
        }

        graph.dijkstra(startVertex);
    }
}