package Y2024M11;

import java.io.*;
import java.util.Stack;

public class P10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        char lastChar = '(';
        for (char c : line.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (lastChar == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
            lastChar = c;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
