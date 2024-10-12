package Y2024M10;

import java.io.*;
import java.util.*;

public class P1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> seeMemberSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seeMemberSet.add(br.readLine());
        }

        List<String> seeAndHearMemberList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (seeMemberSet.contains(name)) {
                seeAndHearMemberList.add(name);
            }
        }
        seeAndHearMemberList.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(seeAndHearMemberList.size()).append("\n");
        for (String name : seeAndHearMemberList) {
            sb.append(name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
