
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        ArrayList<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();

            for (int neighbor : graph[i]) {
                adj[i].add(neighbor);
            }
        }

        return isbipart(adj);
    }

    public static boolean isbipart(ArrayList<Integer>[] graph) {
        int[] col = new int[graph.length];

        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int cur = q.remove();

                    for (int j = 0; j < graph[cur].size(); j++) {
                        int k = graph[cur].get(j);

                        if (col[k] == -1) {
                            int nextcol = col[cur] == 0 ? 1 : 0;
                            col[k] = nextcol;
                            q.add(k);
                        } 
                        else if (col[k] == col[cur]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
