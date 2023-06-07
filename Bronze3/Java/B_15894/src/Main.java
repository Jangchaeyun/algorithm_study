import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(String.valueOf(sc.nextInt()));
        System.out.println(n.multiply(BigInteger.valueOf(4)));
    }
}
