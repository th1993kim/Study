package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1157 {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String word = bufferedReader.readLine();
        String upperWord = word.toUpperCase();


        int[] alphabets = new int[26];
        int maxCount = 0;
        char maxAlphabet = '?';
        int alphabetStart = 65;

        for (int i = 0; i < upperWord.length(); i++) {
            int alphabetIndex = upperWord.charAt(i) - alphabetStart;
            alphabets[alphabetIndex]++;
            int alphabetCount = alphabets[alphabetIndex];
            if (alphabetCount > maxCount) {
                maxCount = alphabetCount;
                maxAlphabet = upperWord.charAt(i);

            } else if (alphabetCount == maxCount) {
                maxAlphabet = '?';
            }
        }

        System.out.println(maxAlphabet);
    }

}
