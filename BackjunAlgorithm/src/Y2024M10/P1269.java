package Y2024M10;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> answerSet = new HashSet<>();
        answerSet.addAll(aSet);
        answerSet.addAll(bSet);

        answerSet.removeIf(number -> aSet.contains(number) && bSet.contains(number));

        bw.write(String.valueOf(answerSet.size()));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }


        Set<Integer> aDifferSet = new HashSet<>(aSet);
        aDifferSet.removeAll(aSet);
        Set<Integer> bDifferSet = new HashSet<>(bSet);
        bDifferSet.removeAll(aSet);

        Set<Integer> answerSet = new HashSet<>();
        answerSet.addAll(aDifferSet);
        answerSet.addAll(bDifferSet);

        bw.write(String.valueOf(answerSet.size()));

        bw.flush();
        bw.close();
        br.close();
    }
}
