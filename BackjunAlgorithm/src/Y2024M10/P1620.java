package Y2024M10;

import java.io.*;
import java.util.*;

public class P1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int output = Integer.parseInt(st.nextToken());

        Map<String, Integer> pocketMap = new HashMap<>();
        List<String> pocketList = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            String pocketMon = br.readLine();
            pocketMap.put(pocketMon, i + 1);
            pocketList.add(pocketMon);
        }


        for (int i = 0; i < output; i++) {
            String question = br.readLine();
            if (pocketMap.containsKey(question)) {
                bw.write(pocketMap.get(question) + "\n");
            } else {
                bw.write(pocketList.get(Integer.parseInt(question) - 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int output = Integer.parseInt(st.nextToken());

        Map<String, Integer> pocketMap = new HashMap<>();
        String[] pocketList = new String[input + 1];
        for (int i = 1; i <= input; i++) {
            String pocketMon = br.readLine();
            pocketMap.put(pocketMon, i);
            pocketList[i] = pocketMon;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < output; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                sb.append(pocketList[Integer.parseInt(question)]).append("\n");
            } else {
                sb.append(pocketMap.get(question)).append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
