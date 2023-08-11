import java.util.ArrayList;
import java.util.List;

public class Question5B {

    private static int depthFirstSearch(int node, boolean[] visited, List<List<Integer>> adjacencyList) {
        visited[node] = true;
        int edgeToReverse = 0;

        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                edgeToReverse += depthFirstSearch(neighbor, visited, adjacencyList) + 1;
            }
        }

        return edgeToReverse;
    }

    public static int edgeReverseFinder(int n, int[][] serverConnection) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] connection : serverConnection) {
            int from = connection[0];
            int to = connection[1];
            adjacencyList.get(from).add(to);
        }

        boolean[] visited = new boolean[n];
        int[] edgeToReverse = new int[n];

        // Calculating the number of edges that has to be reversed for each server
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                edgeToReverse[i] = depthFirstSearch(i, visited, adjacencyList);
            }
        }

        // Find the server with the maximum count of edges to be reversed
        int edgestToReverseMax = 0;
        int maxEdgesServer = 0;
        for (int i = 0; i < n; i++) {
            if (edgeToReverse[i] > edgestToReverseMax) {
                edgestToReverseMax = edgeToReverse[i];
                maxEdgesServer = i;
            }
        }

        return edgestToReverseMax;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] serverConnection = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};

        int result = edgeReverseFinder(n, serverConnection);
        System.out.println("The min number of edges to reverse are: " + result); 
    }
}
