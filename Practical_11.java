import java.util.Arrays;

public class FloydWarshall {
    final static int INF = 99999; // A large value to represent infinity

    // Function to implement Floyd-Warshall Algorithm
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V]; // Distance matrix

        // Initialize the distance matrix same as the input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Adding all vertices one by one as intermediate vertices
        for (int k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {
                // Pick all vertices as destination for the source vertex i
                for (int j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from i to j, then update dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist, V);
    }

    // Utility function to print the solution
    void printSolution(int dist[][], int V) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        
        // Example graph represented as an adjacency matrix
        int graph[][] = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        // Number of vertices
        int V = graph.length;

        // Run the Floyd-Warshall algorithm
        fw.floydWarshall(graph, V);
    }
}
