package Y2024M10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            resultMap.put(Integer.parseInt(st.nextToken()), 1);
        }

        int w = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            if (resultMap.containsKey(Integer.parseInt(st2.nextToken()))) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
