package Y2025M01;

import java.io.*;
import java.util.Scanner;

public class P10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        long a = Long.parseLong(sc.next() + sc.next());
        long b = Long.parseLong(sc.next() + sc.next());


        bw.write(String.valueOf(a + b));
        bw.flush();
        bw.close();
        br.close();
    }
}
