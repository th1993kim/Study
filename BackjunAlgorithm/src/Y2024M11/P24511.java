package Y2024M11;

import java.io.*;
import java.util.*;

public class P24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> dataList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String dataStructure = st.nextToken();
            String data = st2.nextToken();
            if (dataStructure.equals("0")) {
                dataList.add(data);
            }
        }

        int inputSize = Integer.parseInt(br.readLine());
        Queue<String> inputQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputSize; i++) {
            inputQueue.add(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while(!inputQueue.isEmpty()) {
            String input = inputQueue.poll();

            for (int i = 0; i < dataList.size(); i++) {
                String temp = dataList.get(i);
                dataList.set(i, input);
                input = temp;
            }

            sb.append(input).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {

        int n = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String dataStructure = st.nextToken();
            String data = st2.nextToken();
            if (dataStructure.equals("0")) {
                deque.add(data);
            }
        }

        int inputSize = Integer.parseInt(br.readLine());
        Queue<String> inputQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputSize; i++) {
            inputQueue.add(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while(!inputQueue.isEmpty()) {
            deque.addFirst(inputQueue.poll());
            sb.append(deque.pollLast()).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
