package Y2024M10;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] compare = new int[n];
        int[] independent = new int[n];
        int[] countArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
            compare[i] = number;
        }
        Arrays.sort(compare);

        int position = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || compare[i] != compare[i - 1]) {
                independent[i] = compare[i];
                position++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < position; j++) {
                if (arr[i] > independent[j]) {
                    countArr[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(countArr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(int[] arr, int[] compare, BufferedWriter bw) throws IOException {
        Arrays.sort(compare);

        Map<Integer, Integer> indexMap = new HashMap<>();
        int position = 0;
        for (int i = 0; i < compare.length; i++) {
            if (!indexMap.containsKey(compare[i])) {
                indexMap.put(compare[i], position++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(indexMap.get(arr[i]) + " ");
        }
    }
}
