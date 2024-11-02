package Y2024M11;

import java.io.*;
import java.util.Stack;

public class P4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;

        while((str = br.readLine()) != null && !str.isEmpty()) {
            if (str.charAt(0) == '.') {
                break;
            }

            Stack<String> stack = new Stack<>();
            boolean isBalanced = true;
            balanceChecker: for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '(':
                    case '[':
                        stack.push(String.valueOf(str.charAt(i)));
                        break;
                    case ')':
                        if (stack.isEmpty()) {
                            isBalanced = false;
                            break balanceChecker;
                        } else {
                            String pop = stack.pop();
                            if (!pop.equals("(")) {
                                isBalanced = false;
                                break balanceChecker;
                            }
                            break;
                        }
                    case ']':
                        if (stack.isEmpty()) {
                            isBalanced = false;
                            break balanceChecker;
                        } else {
                            String pop = stack.pop();
                            if (!pop.equals("[")) {
                                isBalanced = false;
                                break balanceChecker;
                            }
                            break;
                        }
                }
            }

            if (isBalanced && stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
