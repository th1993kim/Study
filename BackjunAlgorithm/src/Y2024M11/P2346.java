package Y2024M11;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        boolean[] pungsun = new boolean[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int remain = n;

        int pointer = 0;
        bw.write(pointer + 1 + " ");
        pungsun[pointer] = true;
        remain --;

        while (remain > 0) {
            int move = sequence[pointer];
            pointer = pointer + move;
            if (pointer < 0) {
                pointer = n + pointer % n;
            } else if (pointer > n - 1) {
                pointer = pointer % n;
            }
            while (pungsun[pointer]) {
                if (move < 0) {
                    pointer--;
                }

                if (move > 0) {
                    pointer++;
                }

                if (pointer < 0) {
                    pointer = n + pointer % n;
                } else if (pointer > n - 1) {
                    pointer = pointer % n;
                }
            }
            bw.write(pointer + 1 + " ");
            pungsun[pointer] = true;
            remain --;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedWriter bw, BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder result = new StringBuilder();


        while (!deque.isEmpty()) {

            int[] current = deque.pollFirst();
            int index = current[0];
            int move = current[1];

            result.append(index).append(" ");

            if (!deque.isEmpty()) {

                if (move > 0) {
                    for (int i = 0; i < move - 1; i++) {
                        deque.addLast(deque.pollFirst());
                    }
                } else {
                    for (int i = 0; i < -move; i++) {
                        deque.addFirst(deque.pollLast());
                    }
                }
            }

        }


        bw.write(result.toString());
    }

}
