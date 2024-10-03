package Y2024M09;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[][] twoArr = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            twoArr[i][0] = Integer.parseInt(st.nextToken());
            twoArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(twoArr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] oneArr : twoArr) {
            System.out.println(oneArr[0] + " " + oneArr[1]);
            bw.write(oneArr[0] + " " + oneArr[1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
