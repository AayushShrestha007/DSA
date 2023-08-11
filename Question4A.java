import java.util.*;

public class Question4A {

    public int minimumSteps(int n, int[][] taskRelation) {

        // Creating graph using adjacency lists
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Create an array to store the in-degree of each task
        int[] inDegree = new int[n];

        // Build the graph and calculate the in-degree of each task
        for (int[] prerequisite : taskRelation) {
            int x = prerequisite[0] - 1; // Adjusting 1-based indexing to 0-based indexing
            int y = prerequisite[1] - 1; // Adjusting 1-based indexing to 0-based indexing
            graph.get(x).add(y);
            inDegree[y]++;
        }

        // Performing topological sorting using a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int steps = 0;

        // Performing Breadth First Search to find the minimum steps needed to complete all tasks
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int current = queue.poll();
                size--;

                // Process the current task and reduce in-degree of its neighbors
                for (int neighbor : graph.get(current)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            steps++;
        }

        // Check if all tasks have been completed or not
        for (int degree : inDegree) {
            if (degree > 0) {
                return -1; // returning -1 because it's not possible to complete the task since a cycle exists
            }
        }

        return steps - 1; // Last step isn't considered as completing a task so we reduce -1
    }

    public static void main(String[] args) {
        Question4A q4 = new Question4A();
        int n = 3;
        // int[][] taskRelation1 = {{1, 3}, {2, 3}};

        // relation to show a task that can't be completed
        int[][] taskRelation1 = {{1, 3}, {2, 3}, {3,2}};

        int result = q4.minimumSteps(n, taskRelation1);

        if(result!=-1){
            System.out.println("The minimum steps needed are: " + result);
        }
        else{
            System.out.println("No way to complete all task");
        }
        
    }
}
