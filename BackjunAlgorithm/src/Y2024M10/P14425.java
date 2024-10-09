package Y2024M10;

import java.io.*;
import java.util.*;

public class P14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> sSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sSet.add(br.readLine());
        }

        int totalCount = 0;
        for (int i = 0; i < m; i++) {
            if (sSet.contains(br.readLine())) {
                totalCount++;
            }
        }

        bw.write(totalCount + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
