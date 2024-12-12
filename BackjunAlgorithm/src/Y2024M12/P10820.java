package Y2024M12;

import java.io.*;

public class P10820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr;
        StringBuilder result = new StringBuilder();

        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {

            arr = new int[4];
            char[] charArray = line.toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                if (Character.isAlphabetic(c)) {
                    if (Character.isLowerCase(c)) {
                        arr[0]++;
                    } else {
                        arr[1]++;
                    }
                } else if (Character.isDigit(c)) {
                    arr[2]++;
                } else {
                    arr[3]++;
                }
            }

            for (int k = 0; k < arr.length; k++) {
                result.append(arr[k]).append(" ");
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
