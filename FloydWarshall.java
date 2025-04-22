public class FloydWarshall {

    final static int INF = 99999; // Represents infinity

    // Function to implement the Floyd-Warshall algorithm
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V]; // int dist[i][j]=graph[i][j] dist[i][k]!=INF dist[k][j]!=INF

        // Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Updating the distances using intermediate vertices
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the final shortest distance matrix
        printSolution(dist, V);
    }

    // Utility function to print the solution matrix
    void printSolution(int dist[][], int V) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 4;

        /* Initial graph matrix (adjacency matrix)
           2 is connected to 1 with weight 4
           1 is connected to 3 with weight -2
           3 is connected to 4 with weight 2
           4 is connected to 2 with weight -1
           2 is connected to 3 with weight 3
           Rest is initialized to INF (no direct connection)
        */
        int graph[][] = {
            {0, INF, -2, INF},  // 1 -> 3 with weight -2
            {4, 0, 3, INF},     // 2 -> 1 with weight 4, 2 -> 3 with weight 3
            {INF, INF, 0, 2},   // 3 -> 4 with weight 2
            {INF, -1, INF, 0}   // 4 -> 2 with weight -1
        };

        // Create an instance of the FloydWarshall class and call the algorithm
        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph, V);
    }
}

