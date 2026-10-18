
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int cur, int c, int[][] graph, int[] color) {
        color[cur] = c;

        for (int neighbor : graph[cur]) {

            // Unvisited neighbor
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - c, graph, color)) {
                    return false;
                }
            }

            // Same color means an odd cycle
            else if (color[neighbor] == color[cur]) {
                return false;
            }
        }

        return true;
    }
}
