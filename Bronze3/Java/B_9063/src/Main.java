import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

interface Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int minX = 10000, minY = 10000, maxX = -10000, maxY = -10000;
        for(int i=0; i<N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            minX = minX>input[0]?input[0]:minX;
            minY = minY>input[1]?input[1]:minY;
            maxX = maxX<input[0]?input[0]:maxX;
            maxY = maxY<input[1]?input[1]:maxY;
        }
        System.out.println((maxX - minX) * (maxY - minY));
    }
}