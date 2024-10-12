package Y2024M10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> countMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(st.nextToken());
            countMap.put(input, countMap.getOrDefault(input, 0) + 1);
        }


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            sb.append(countMap.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
