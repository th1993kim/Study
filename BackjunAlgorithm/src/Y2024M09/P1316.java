package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            boolean isContinueWord = true;
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j - 1) != word.charAt(j) && word.indexOf(word.charAt(j)) != j) {
                    isContinueWord = false;
                    break;
                }
            }

            if (isContinueWord) {
                result++;
            }
        }

        System.out.println(result);


    }
}
