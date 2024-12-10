package Y2024M12;

import java.io.*;

public class P10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphaCount = new int[26];
        StringBuilder result = new StringBuilder();

        String line = br.readLine();

        char[] charArray = line.toCharArray();

        for (char c : charArray) {
            alphaCount[c - 'a']++;
        }

        for (int i = 0; i < alphaCount.length; i++) {
            result.append(alphaCount[i]).append(" ");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
