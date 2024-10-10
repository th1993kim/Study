package Y2024M10;

import java.io.*;
import java.util.*;

public class P7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Set<String> entranceCheckSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if ("enter".equals(state)) {
                entranceCheckSet.add(name);
            } else {
                entranceCheckSet.remove(name);
            }
        }

        String[] entranceArrays = entranceCheckSet.toArray(new String[0]);
        Arrays.sort(entranceArrays, Comparator.reverseOrder());

        for (String entrance : entranceArrays) {
            bw.write(entrance + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static List<String> gptSolution(Set<String> entranceCheckSet) {
        List<String> entranceList = new ArrayList<>(entranceCheckSet);
        entranceList.sort(Collections.reverseOrder());
        return entranceList;
    }
}
