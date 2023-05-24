import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int x, y;

        int time[]= {sc.nextInt(),sc.nextInt(),sc.nextInt()};

        int count[]= new int[3];
        for(int i=0; i<3; i++) {
            count[i]=0;
        }
        for(int i=0; i<3; i++) {
            x=time[i]%(a+b);
            y=time[i]%(c+d);
            if(x<=a&&x>0) {
                count[i]++;
            }
            if(y<=c&&x>0) {
                count[i]++;
            }
            System.out.println(count[i]);
        }
    }
}