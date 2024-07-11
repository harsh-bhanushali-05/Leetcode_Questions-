import java.util.*;

class Solution {
    class DisjointSet {
        int[] rank;
        int[] parent;

        DisjointSet(int v) {
            rank = new int[v];
            parent = new int[v];
            Arrays.fill(rank, 0);
            for (int i = 0; i < v; i++)
                parent[i] = i;
        }

        public int find(int n) {
            if (parent[n] == n) return n;
            return parent[n] = find(parent[n]);
        }

        public void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu != pv) {
                if (rank[pu] > rank[pv]) {
                    parent[pv] = pu;
                } else if (rank[pu] < rank[pv]) {
                    parent[pu] = pv;
                } else {
                    parent[pv] = pu;
                    rank[pu]++;
                }
            }
        }

        public boolean same(int u, int v) {
            return find(u) == find(v);
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class Pair {
        Point u;
        Point v;
        int wt;

        Pair(Point u, Point v) {
            this.u = u;
            this.v = v;
            this.wt = Math.abs(u.x - v.x) + Math.abs(u.y - v.y);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, Point> map = new HashMap<>();
        HashMap<Point, Integer> rev = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            Point point = new Point(points[i][0], points[i][1]);
            map.put(i, point);
            rev.put(point, i);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                pq.offer(new Pair(map.get(i), map.get(j)));
            }
        }

        DisjointSet obj = new DisjointSet(points.length);
        int ans = 0;
        int edgesUsed = 0;
        while (!pq.isEmpty() && edgesUsed < points.length - 1) {
            Pair temp = pq.poll();
            int u = rev.get(temp.u);
            int v = rev.get(temp.v);
            if (!obj.same(u, v)) {
                obj.union(u, v);
                ans += temp.wt;
                edgesUsed++;
            }
        }
        return ans;
    }
}