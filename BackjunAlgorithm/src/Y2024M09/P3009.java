package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P3009 {

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token;
        while ((token = br.readLine()) != null && !token.isEmpty()) {
            StringTokenizer st = new StringTokenizer(token);
            putValueCount(Integer.parseInt(st.nextToken()), xMap);
            putValueCount(Integer.parseInt(st.nextToken()), yMap);
        }

        int x= xMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        int y = yMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println(x + " " + y);
    }

    private static void putValueCount(int countKey, Map<Integer, Integer> countMap) {
        countMap.put(countKey, countMap.getOrDefault(countKey, 0) + 1);
    }


    private static void solutionGpt(BufferedReader br) throws IOException {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());

            x ^= xi;
            y ^= yi;
        }

        System.out.println(x + " " + y);
    }

    private static void otherSolution(BufferedReader br) throws IOException {

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int fourthX = x[0] == x[1] ? x[2] : (x[0] == x[2] ? x[1] : x[0]);
        int fourthY = y[0] == y[1] ? y[2] : (y[0] == y[2] ? y[1] : y[0]);

        System.out.println(fourthX + " " +fourthY);
    }
}
