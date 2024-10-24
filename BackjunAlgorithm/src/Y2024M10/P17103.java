package Y2024M10;

import java.io.*;

public class P17103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[1000000 + 1];
        arr[0] = arr[1] = true;
        for (int i = 2; i * i < arr.length; i++) {
            if (!arr[i]) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            int count = 0;

            for (int j = 2; j <= number/2; j++) {
                if (!arr[j]) {
                    for (int k = j; k < number; k++) {
                        if (j + k > number) {
                            break;
                        }

                        if (!arr[k] && (j + k == number)) {
                            count ++;
                        }
                    }
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
