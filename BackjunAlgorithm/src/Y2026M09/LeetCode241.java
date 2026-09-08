package Y2026M09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode241 {
    static class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            // 그래프를 만들고  a - > b -- 가중치 b -> a -- 가중치 이런식으로 그래프를 그리고
            // 각 요소간 이동시를 가중치를 곱해주는 방식으로진행해보자.

            Map<String, Map<String, Double>> graph = new HashMap<>();
            double[] answer = new double[queries.size()];
            // 그래프 생성
            for (int i = 0; i < equations.size(); i++) {
                // a -> b
                graph.computeIfAbsent(equations.get(i).get(0), k -> new HashMap<>())
                        .put(equations.get(i).get(1), values[i]);

                // b -> a
                graph.computeIfAbsent(equations.get(i).get(1), k -> new HashMap<>())
                        .put(equations.get(i).get(0), 1.0 / values[i]);
            }

            for (int i = 0; i < queries.size(); i++) {
                String start = queries.get(i).get(0);
                String end = queries.get(i).get(1);
                if (!graph.containsKey(start) || !graph.containsKey(end)) {
                    answer[i] = -1.0;
                    continue;
                }
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(
                        start,
                        end,
                        1.0,
                        visited,
                        graph
                );
            }

            return answer;
        }

        double dfs(String start, String end, double value, Set<String> visited, Map<String, Map<String, Double>> graph) {
            if (start.equals(end)) return value;

            visited.add(start);
            Map<String, Double> nextMap = graph.get(start);
            if (nextMap == null) return -1.0;
            for(Map.Entry<String, Double> entry : nextMap.entrySet()) {
                String key = entry.getKey();
                Double weight = entry.getValue();
                if (!visited.contains(key)) {
                    double result = dfs(
                            key,
                            end,
                            value * weight,
                            visited,
                            graph
                    );
                    if (result != -1.0) {
                        return result;
                    }
                }
            }

            return -1.0;
        }
    }
}
