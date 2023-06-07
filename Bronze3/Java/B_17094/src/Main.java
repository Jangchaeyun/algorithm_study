import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int two = 0;
        int alp = 0;
        String word = sc.next();
        char[] arr = new char[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = word.charAt(i);
            if (arr[i] == '2')
                two++;
            else
                alp++;
        }
        if (two == alp)
            System.out.println("yee");
        else if (two > alp)
            System.out.println("2");
        else
            System.out.println("e");
    }
}
