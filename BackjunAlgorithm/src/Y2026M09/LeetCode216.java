package Y2026M09;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode216 {
    class Solution {
        public String simplifyPath(String path) {

            // split을 이용해 "/" 단위를 분리해보자.
            // 분리 후 발생할 수 있는 예외케이스들
            // "", "." -> 이게 나온다면 현재 반복문은 제외한다.
            // ".." -> 이게 나온다면 Deque에서 마지막 요소를 뺀다.
            // 나머지는 Deque에 넣는다.
            // Deque 구조이기때문에, 반복문을 통해 경로를 다시 생성해준다.

            String[] split = path.split("/");

            Deque<String> deque = new ArrayDeque<>();

            for (int i = 0; i < split.length; i++) {
                if (split[i].isEmpty() || split[i].equals(".")) {
                    continue;
                } else if (split[i].equals("..")) {
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                } else {
                    deque.addLast(split[i]);
                }
            }

            if (deque.isEmpty()) {
                return "/";
            }

            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append("/").append(deque.poll());
            }

            return sb.toString();

        }
    }
}
