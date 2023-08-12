import java.util.List;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.ArrayList;

public class Question3bBellmanford {
    

    public static int[] bellmanFord(int[][] graph, int vertices, int source) throws Exception {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
         
            for(int j=0; j<graph.length;j++){
                int u= graph[j][0];
                int v= graph[j][1];
                int w= graph[j][2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Detecting negative weight cycles

        for(int j=0; j<graph.length;j++){
                int u= graph[j][0];
                int v= graph[j][1];
                int w= graph[j][2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    //throw exception if negative weight cycle is found
                    throw new Exception("Graph contains a negative weight cycle");
                }
            }

        

        return distance;
    }

    //main code to run bell man ford algorithm
    public static void main(String[] args) {
    
        int[][] graph = {
            {0,1,2},
            {0,2,3},
            {0,3,5},
            {1,2,-1},
            {2,3,4},
            {3,4,2},
            {4,0,1}
        };

        // graph to test for negative weight cycle
        // int[][] graph = {

        //     {0,1,-1},
        //     {1,2,-2},
        //     {2,0,-3}

        // };

        int vertices = 5;
        int sourceVertex = 0;

        try {
            int[] distance = bellmanFord(graph, vertices, sourceVertex);
            System.out.println("Shortest distance from source vertex " + sourceVertex + ": ");
            for (int i = 0; i < vertices; i++) {
                //prints out shortest distance of each vertext from source 0
                System.out.println( i + "= " + distance[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}






