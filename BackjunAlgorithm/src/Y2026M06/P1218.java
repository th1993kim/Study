package Y2026M06;

import java.util.*;

public class P1218 {

    static int n, count;
    static Map<Integer, List<Integer>> associationMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> aMap = associationMap.get(a);
            if (aMap == null) {
                aMap = new ArrayList<>();
                aMap.add(b);
            } else {
                aMap.add(b);
            }
            List<Integer> bList = associationMap.get(b);
            if (bList == null) {
                bList = new ArrayList<>();
                bList.add(a);
            } else {
                bList.add(a);
            }
            associationMap.putIfAbsent(a, aMap);
            associationMap.putIfAbsent(b, bList);
        }

        int front = scanner.nextInt();
        int back = scanner.nextInt();
        System.out.println(solution(front, back));


    }

    private static String solution(int front, int back) {
        String answer = "NO";
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> associatedValues = associationMap.get(front);
        if (associatedValues == null) {return answer;}
        associationMap.remove(front);
        for (Integer associatedValue : associatedValues) {
            if (associatedValue == back) {
                return "YES";
            }
            queue.offer(associatedValue);
        }

        while(!queue.isEmpty()) {
            Integer queueValue = queue.poll();
            List<Integer> queueValues = associationMap.get(queueValue);
            if (queueValues != null && !queueValues.isEmpty()) {
                associationMap.remove(queueValue);
                for (Integer associatedValue : queueValues) {
                    if (associatedValue == back) {
                        return "YES";
                    }
                    queue.offer(associatedValue);
                }
            }
        }

        return answer;
    }
}
