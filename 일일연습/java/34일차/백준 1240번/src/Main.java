import java.util.*;
 
public class Main {    
 
    static int n, m;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        m = scan.nextInt();
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n - 1; i++) {
            int s = scan.nextInt();
            int d = scan.nextInt();
            int v = scan.nextInt();
            list[s].add(new Node(d, v));
            list[d].add(new Node(s, v));
        }
        
        for(int i = 0; i < m; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            visited = new boolean[n + 1];
            dijkstra(start, end);
            System.out.println(dist[end]);
        }
    }    
    
    public static void dijkstra(int s, int e) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[s] = 0;
        q.offer(new Node(s, 0));
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if(visited[current.n] == false) visited[current.n] = true;
            else continue;
            
            for(int i = 0; i < list[current.n].size(); i++) {
                Node next = list[current.n].get(i);
                if(dist[next.n] > dist[current.n] + next.v) {
                    dist[next.n] = dist[current.n] + next.v;
                    q.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int n;
        int v;
        
        public Node(int n, int v) {
            this.n = n;
            this.v = v;
        }
        
        @Override
        public int compareTo(Node node) {
            return this.v - node.v;
        }
    }
}