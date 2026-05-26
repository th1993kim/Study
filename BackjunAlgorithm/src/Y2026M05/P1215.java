package Y2026M05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1215 {


    static class Body {
        int weight, height;
        Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int compareTo(Body body) {
            return body.height - this.height;
        }
    }
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Body> bodyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bodyList.add(new Body(scanner.nextInt(), scanner.nextInt()));
        }

        solution(bodyList);

        System.out.println(answer);
    }

    private static void solution(List<Body> bodyList) {
        bodyList.sort(Body::compareTo);

        int maxWeight = 0;
        for (Body body : bodyList) {
            int bodyWeight = body.weight;
            if (maxWeight < bodyWeight) {
                answer++;
                maxWeight = bodyWeight;
            }
        }
    }
}
