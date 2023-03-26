import java.util.*;

public class Main {
    static class Point {
        int x, y, z;
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int n;
    static Point[] a;
    static boolean[] check;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[i] = new Point(x, y, z);
        }

        check = new boolean[n];
        go(0, 0);
        System.out.println(ans);
    }

    static void go(int index, int selected) {
        if (selected == 2) {
            long dist = distance();
            if (dist < ans) {
                ans = dist;
            }
            return;
        }
        if (index >= n) return;
        check[index] = true;
        go(index+1, selected+1);
        check[index] = false;
        go(index+1, selected);
    }

    static long distance() {
        int[] selected = new int[2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                selected[idx++] = i;
            }
        }

        long dx = a[selected[0]].x - a[selected[1]].x;
        long dy = a[selected[0]].y - a[selected[1]].y;
        long dz = a[selected[0]].z - a[selected[1]].z;

        return dx*dx + dy*dy + dz*dz;
    }
}
