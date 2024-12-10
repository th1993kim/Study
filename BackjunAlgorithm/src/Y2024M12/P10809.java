package Y2024M12;

import java.io.*;
import java.util.Arrays;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        int[] alphaIndex = new int[26];
        Arrays.fill(alphaIndex, -1);

        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int position = charArray[i] - 'a';
            if (alphaIndex[position] == -1) {
                alphaIndex[position] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < alphaIndex.length; i++) {
            result.append(alphaIndex[i]).append(' ');
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
