import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int useB = 0;
        int nowB = 0;
        int phoneNum = 0;

        int[] phoneArr = new int[N];

        for (int i = 0; i < N; i++) {
            phoneArr[i] = sc.nextInt();

            if (phoneNum == phoneArr[i]) {
                useB = useB * 2;
                nowB = nowB +useB;
            } else {
                phoneNum = phoneArr[i];
                useB = 2;
                nowB = nowB + useB;
            }
            if (nowB >= 100) {
                phoneNum = 0;
                useB = 0;
                nowB = 0;
            }
        }
        System.out.println(nowB);
        sc.close();
    }
}
