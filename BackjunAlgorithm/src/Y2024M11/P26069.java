package Y2024M11;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P26069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        final String chongChong = "ChongChong";
        Set<String> memberSet = new HashSet<>();
        memberSet.add(chongChong);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String ai = st.nextToken();
            String bi = st.nextToken();

            if (memberSet.contains(ai) || memberSet.contains(bi)) {
                memberSet.add(ai);
                memberSet.add(bi);
            }
        }

        bw.write(String.valueOf(memberSet.size()));

        bw.flush();
        bw.close();
        br.close();
    }
}
