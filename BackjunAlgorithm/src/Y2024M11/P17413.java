package Y2024M11;

import java.io.*;
import java.util.Stack;

public class P17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        boolean tag = false;

        char[] charArray = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char charChar : charArray) {

            if (tag) {
                sb.append(charChar);
            }

            if (charChar == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                tag = true;
                sb.append(charChar);
            }

            if (charChar == '>') {
                tag = false;
                continue;
            }


            if (!tag) {
                if (charChar == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(charChar);
                    continue;
                }
                stack.push(charChar);
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedWriter bw, BufferedReader br) throws IOException {
        String input = br.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder reverseWord = new StringBuilder();
        boolean tag = false;
        for (char c : input.toCharArray()) {
            if (c == '<') {
                if (reverseWord.length() > 0) {
                    result.append(reverseWord.reverse());
                    reverseWord.setLength(0);
                }
                tag = true;
                result.append(c);
            } else if (c == '>') {
                tag = false;
                result.append(c);
            } else if (c == ' ' && !tag) {
                result.append(reverseWord.reverse());
            } else {
                if (tag) {
                    result.append(c);
                } else {
                    reverseWord.append(c);
                }
            }
        }

        if (reverseWord.length() > 0) {
            result.append(reverseWord.reverse());
        }
        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
