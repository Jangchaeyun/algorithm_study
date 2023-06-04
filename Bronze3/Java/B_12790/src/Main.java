import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =0; i<t; i++){
            String tc = br.readLine();
            st = new StringTokenizer(tc, " ");
            int chp = Integer.parseInt(st.nextToken());
            int cmp = Integer.parseInt(st.nextToken());
            int cattack = Integer.parseInt(st.nextToken());
            int cdefence = Integer.parseInt(st.nextToken());
            int ehp = Integer.parseInt(st.nextToken());
            int emp = Integer.parseInt(st.nextToken());
            int eattack = Integer.parseInt(st.nextToken());
            int edefence = Integer.parseInt(st.nextToken());
            System.out.println(1*checkHP(chp,ehp)+5*checkMP(cmp, emp)+2*checkAttack(cattack, eattack)+2*(cdefence+edefence));
        }

    }

    static int checkHP(int a, int b){
        if(a+b<1){
            return 1;
        }
        else{
            return a+b;
        }
    }

    static int checkMP(int a, int b){
        if(a+b<1){
            return 1;
        }
        else{
            return a+b;
        }
    }

    static int checkAttack(int a, int b){
        if(a+b<0){
            return 0;
        }
        else{
            return a+b;
        }
    }

}