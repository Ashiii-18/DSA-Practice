class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] ans = new int[n];
        int i = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[i++] = curr;

            for (int next : graph.get(curr)) {
                indegree[next]--;

                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        return i == n ? ans : new int[0];
    }
}