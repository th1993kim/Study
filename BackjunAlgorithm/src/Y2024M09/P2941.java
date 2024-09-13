package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String keyword = bufferedReader.readLine();
        String[] croatiaWords = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String croatiaWord : croatiaWords) {
            keyword = keyword.replaceAll(croatiaWord, "#");
        }

        System.out.println(keyword.length());
    }
}
