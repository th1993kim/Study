package Y2024M11;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P25192 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Set<String> userNameSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if ("ENTER".equals(line)) {
                userNameSet = new HashSet<>();
            } else if (!userNameSet.contains(line)) {
                userNameSet.add(line);
                result++;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
