package Y2024M11;

import java.io.*;

public class P15439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        bw.write("" +n * (n - 1));

        bw.flush();
        bw.close();
        br.close();
    }
}
