
class Solution {

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    static class Info {
        int v, cost, stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static void creategraph(int[][] flights,
                                   ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        creategraph(flights, graph);

        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {

            Info curr = q.remove();

            if (curr.stops > k) {
                continue;
            }

            for (Edge e : graph[curr.v]) {

                int v = e.dest;
                int newCost = curr.cost + e.wt;

                if (newCost < dist[v]) {

                    dist[v] = newCost;

                    q.add(new Info(v, newCost,
                                   curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
               ? -1 : dist[dst];
    }
}
