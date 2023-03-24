import java.util.stream.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

import java.util.*;
import java.io.*;

public class Main {

    static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = input[0]; m = input[1]; k = input[2];

        ArrayList<ArrayList<Node>> road = new ArrayList<>();
        for(int i=0;i<=n;i++) road.add(new ArrayList<>());

        for(int i=1;i<=m;i++){
            input = stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            road.get(input[0]).add(new Node(input[1],input[2],0));
            road.get(input[1]).add(new Node(input[0],input[2],0)); // 도로 양방향 연결
        } // end input

        System.out.println(findShortPath(1,road));

    }

    static long findShortPath(int start,ArrayList<ArrayList<Node>> road) {

        long[][] distance = new long[n+1][k+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(distance[i],Long.MAX_VALUE);

        distance[start][0]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.weight));
        pq.add(new Node(start,0,0));

        while (!pq.isEmpty()){

            Node cur = pq.poll();

            if(cur.weight > distance[cur.node][cur.cnt])
                continue;

            for (Node next : road.get(cur.node)) {

                //도로를 포장했을경우 => next 노드의 weight 값을 합산 x
                if(cur.cnt<k && distance[next.node][cur.cnt+1] > distance[cur.node][cur.cnt] ){
                    distance[next.node][cur.cnt+1] = distance[cur.node][cur.cnt] ;
                    pq.add(new Node(next.node,distance[next.node][cur.cnt+1],cur.cnt+1));
                }

                //도로를 포장하지 않았을 경우 => next 노드의 weight 값 합산
                if(distance[next.node][cur.cnt] > distance[cur.node][cur.cnt] + next.weight ){
                    distance[next.node][cur.cnt] = distance[cur.node][cur.cnt] + next.weight;
                    pq.add(new Node(next.node,distance[next.node][cur.cnt],cur.cnt));
                }
            }
        }
        
        return Arrays.stream(distance[n]).min().getAsLong();
    }

    static class Node{
        int node,cnt;
        long weight;

        public Node(int node, long weight, int cnt) {
            this.node = node;
            this.cnt = cnt;
            this.weight = weight;
        }
    }
}