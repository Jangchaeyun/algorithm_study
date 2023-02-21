import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Tomato {
    int x;
    int y;
 
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
}
 
public class Main {
 
    public static int m;
    public static int n;
    public static int[][] arr;
    public static int[] dirX = { -1, 1, 0, 0 };
    public static int[] dirY = { 0, 0, -1, 1 };
 
    public static Queue<Tomato> queue;
 
    public static int bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int x = tomato.x;
            int y = tomato.y;
 
            for (int i = 0; i < 4; i++) {
                int X = tomato.x + dirX[i];
                int Y = tomato.y + dirY[i];
                if (X >= 0 && X < n && Y >= 0 && Y < m) {
                    if (arr[X][Y] == 0) {
 
                        queue.add(new Tomato(X, Y));
                        arr[X][Y] = arr[x][y] + 1;
 
                    }
                }
            }
 
        }
        int result = Integer.MIN_VALUE;
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return -1;
 
                }
                result = Math.max(result, arr[i][j]);
            }
 
        }
        if (result == 1) {
            return 0;
        } else {
            return (result - 1);
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        queue = new LinkedList<Tomato>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    queue.add(new Tomato(i, j));
 
                }
            }
        }
 
        System.out.println(bfs());
 
    }
 
}
