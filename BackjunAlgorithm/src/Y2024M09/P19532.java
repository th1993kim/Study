package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19532 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());


        parent: for (int i=-999; i<1000; i++) {
            int ax = a * i;
            int dx = d * i;
            for (int j=-999; j<1000; j++) {
                if ((ax + b * j) == c && (dx + e * j) == f) {
                    System.out.println(i + " " + j);
                    break parent;
                }
            }
        }
    }
}
