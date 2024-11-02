package Y2024M10;

import java.io.*;
import java.util.Stack;

public class P9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int sum = 0;
            String str = br.readLine();
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c == '(') {
                    sum++;
                } else {
                    sum--;
                    if (sum < 0) {
                        break;
                    }
                }
            }

            if (sum == 0) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            int sum = 0;
            String str = br.readLine();
            char[] charArray = str.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '(') {
                    stack.push(String.valueOf(charArray[j]));
                } else {
                    if (stack.isEmpty()) {
                        sum = -1;
                        break;
                    }
                    stack.pop();
                }
            }

            if (sum == 0 && stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
