import java.util.*;
public class ShortestPath{
    static class Pair implements Comparable<Pair> {
        int vertex, weight;

        Pair(int v, int w)
        {
            vertex = v;
            weight = w;
        }
        public int compareTo(Pair other)
        {
            return Integer.compare(this.weight,
                                   other.weight);
        }
    }
    static void dijkstra(int[][] graph,int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Pair(src, 0));
        dist[src] = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            for(int i=0;i<graph.length;i++){
                int w = graph[u][i];
                if((w!=Integer.MAX_VALUE) && (u!=i && dist[i] > dist[u]+w)){
                    dist[i] = dist[u] + w;
                    pq.add(new Pair(i, dist[i]));
                }
            }
        }
        System.out.println("Distance Array: "+Arrays.toString(dist));

    }
    static void bellmanFord(int[][] edges,int src,int V,int E){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V-1; i++){
            for (int j = 0; j < E; j++) {
                if (dist[edges[j][0]] != Integer.MAX_VALUE && dist[edges[j][0]] + edges[j][2] <dist[edges[j][1]])
                    dist[edges[j][1]] = dist[edges[j][0]] + edges[j][2];
            }
        }
        for (int i = 0; i < E; i++) 
        {
            int x = edges[i][0];
            int y = edges[i][1];
            int weight = edges[i][2];
            if (dist[x] != Integer.MAX_VALUE && dist[x] + weight < dist[y])
                System.out.println("Graph contains negative"
                        +" weight cycle");
        }
 
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }
    public static void main (String[] args) {
        

        
        int graph[][] = {{0,4,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,8,Integer.MAX_VALUE},
                        {Integer.MAX_VALUE,0,7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,11,Integer.MAX_VALUE},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,0,7,Integer.MAX_VALUE,4,Integer.MAX_VALUE,Integer.MAX_VALUE,2},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,9,14,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,10,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,2,Integer.MAX_VALUE,Integer.MAX_VALUE},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,1,6},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,7},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}
        };
        int edges[][]={{0,1,4},{0,7,8},{1,2,7},{1,7,11},{2,3,7},{2,5,4},{2,8,2},{3,4,9},{3,5,14},{4,5,10},{5,6,2},{6,7,1},{6,8,6},{7,8,7}};
        dijkstra(graph,0);
        bellmanFord(edges,0,9,14);
    }
    
    
}
