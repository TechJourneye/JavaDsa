import java.util.*;

public class TSPBruteForce {
    static int V = 4; // Number of cities

    // Sample cost matrix (adjacency matrix)
    static int[][] graph = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    static int minCost = Integer.MAX_VALUE;
    static List<Integer> bestPath = new ArrayList<>();

    // Function to calculate path cost
    static int calculateCost(List<Integer> path) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            cost += graph[path.get(i)][path.get(i + 1)];
        }
        // Return to start city
        cost += graph[path.get(path.size() - 1)][path.get(0)];
        return cost;
    }

    // Function to generate permutations and find minimum cost path
    static void tsp(List<Integer> cities, int start) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(cities, 0, permutations);

        for (List<Integer> perm : permutations) {
            List<Integer> fullPath = new ArrayList<>();
            fullPath.add(start);
            fullPath.addAll(perm);

            int cost = calculateCost(fullPath);
            if (cost < minCost) {
                minCost = cost;
                bestPath = new ArrayList<>(fullPath);
            }
        }
    }

    // Function to generate permutations
    static void permute(List<Integer> arr, int l, List<List<Integer>> result) {
        if (l == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = l; i < arr.size(); i++) {
            Collections.swap(arr, i, l);
            permute(arr, l + 1, result);
            Collections.swap(arr, i, l); // backtrack
        }
    }

    public static void main(String[] args) {
        List<Integer> cities = new ArrayList<>();
        for (int i = 1; i < V; i++) {
            cities.add(i);
        }

        tsp(cities, 0); // Start from city 0

        System.out.println("Minimum tour cost: " + minCost);
        System.out.println("Tour path: " + bestPath + " -> " + bestPath.get(0));
    }
}

