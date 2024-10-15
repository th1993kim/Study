package Y2024M10;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] strCharArray = str.toCharArray();

        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < strCharArray.length; i++) {
            for (int j = i; j < strCharArray.length; j++) {
                strSet.add(str.substring(i, j + 1));
            }
        }

        bw.write(String.valueOf(strSet.size()));

        bw.flush();
        bw.close();
        br.close();
    }
}
