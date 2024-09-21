package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            int max = Math.max(Math.max(a, b), c);
            if ((a == max && a >= (b + c))
                    || (b == max && b >= (a + c))
                    || (c == max && c >= (a + b))) {
                System.out.println("Invalid");
                continue;
            }
            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || a == c || b == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }

    private static void gptAnswer(BufferedReader br) throws IOException {
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            if (!isInvalidTriangle(a, b, c)) {

            }else if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || a == c || b == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }

    private static boolean isInvalidTriangle(int a, int b, int c) {
        return (a + b) < c && (b + c) < a && (a + c) < b;
    }
}
