package Y2024M09;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        otherSolution(br, bw);

        int n = Integer.parseInt(br.readLine());

        Set<String> hashSet = new HashSet<>();
        for (int i=0; i<n; i++) {
            hashSet.add(br.readLine());
        }

        String[] arr = hashSet.toArray(String[]::new);

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String word : arr) {
            bw.write(word + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] strArr = new String[n];
        for (int i=0; i<n; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < strArr.length; i++) {
            if (i==0 || !strArr[i].equals(strArr[i-1])) {
                bw.write(strArr[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
