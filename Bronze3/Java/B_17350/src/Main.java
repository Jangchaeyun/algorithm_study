import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean chk = false;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.equals("anj")) chk = true;
        }
        if (chk) bw.write("뭐야;\n");
        else bw.write("뭐야?\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
