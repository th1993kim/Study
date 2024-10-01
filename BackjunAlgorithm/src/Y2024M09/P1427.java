package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberString = br.readLine();
        int[] arr = new int[numberString.length()];
        for (int i=0; i<numberString.length(); i++) {
            arr[i] = numberString.charAt(i) - '0';
        }

        Arrays.sort(arr);

        for (int i=arr.length-1; i>=0; i--) {
            System.out.print(arr[i]);
        }
    }


    private static void gptSolution(String numberString) {
        char[] charArray = numberString.toCharArray();

        Arrays.sort(charArray);


        for (int i=charArray.length-1; i>=0; i--) {
            System.out.print(charArray[i]);
        }
    }

    private static void gtpSolution2(String numberString) {
        int[] digitCount = new int[10];

        for (char digit : numberString.toCharArray()) {
            digitCount[digit - '0']++;
        }

        for (int i=9; i>=0; i--) {
            while (digitCount[i]-- > 0) {
                System.out.print(i);
            }
        }
    }
}
