package Y2025M01;

import java.io.*;

public class P11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        char[] charArray = input.toCharArray();
        int rot = 13;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char word = charArray[i];
            if (Character.isAlphabetic(word)) {
                if (Character.isUpperCase(word)) {
                    word =  (char) (((word - 'A' + rot) % 26) + 'A');
                } else {
                    word = (char) (((word - 'a' + rot) % 26) + 'a');
                }
            }
            sb.append(word);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
