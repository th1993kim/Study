package Y2025M01;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] stringArr = new String[s.length()];
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = "";
            for (Character c : queue) {
                stringArr[i] += c;
            }
            queue.remove();
        }

        Arrays.sort(stringArr);
        StringBuilder sb = new StringBuilder();
        for (String string : stringArr) {
            sb.append(string).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {

        String word = br.readLine();
        String[] stringArr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            stringArr[i] = word.substring(i);
        }
        Arrays.sort(stringArr);

        StringBuilder sb = new StringBuilder();
        for (String keyword : stringArr) {
            sb.append(keyword).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
