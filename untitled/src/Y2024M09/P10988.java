package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyword = br.readLine();

        int halfLength = keyword.length() / 2;

        for (int i = 0; i < halfLength; i++) {
            if (keyword.charAt(i) != keyword.charAt(keyword.length() - 1 - i)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
