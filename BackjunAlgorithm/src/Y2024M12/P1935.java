package Y2024M12;

import java.io.*;
import java.util.Stack;

public class P1935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        double[] arr = new double[26];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (char c : line.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                stack.push(arr[c - 'A']);
            } else {
                Double firstNumber = stack.pop();
                Double secondNumber = stack.pop();
                switch (c) {
                    case '+': stack.push(secondNumber + firstNumber); break;
                    case '-': stack.push(secondNumber - firstNumber); break;
                    case '*': stack.push(secondNumber * firstNumber); break;
                    case '/': stack.push(secondNumber / firstNumber); break;
                };
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();
        br.close();
    }
}
