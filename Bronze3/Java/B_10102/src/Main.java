import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt1 = 0;
        int cnt2 = 0;
        String vote = sc.next();
        for (int i = 0; i < vote.length(); i++) {
            if (vote.charAt(i) == 'A')
                cnt1++;
            else if (vote.charAt(i) == 'B')
                cnt2++;
        }
        sc.close();
        if (cnt1 > cnt2)
            System.out.println("A");
        else if (cnt1 < cnt2)
            System.out.println("B");
        else
            System.out.println("Tie");
    }
}