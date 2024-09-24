package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cardCount = Integer.parseInt(st.nextToken());
        int blackJack = Integer.parseInt(st.nextToken());

        int[] cards = new int[cardCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=0; i<cardCount; i++) {
            for (int j=0; j<cardCount; j++) {
                if (i == j) continue;
                for (int k=0; k<cardCount; k++) {
                    if (i == k || j == k) continue;
                    int tempSum = cards[i] + cards[j] + cards[k];
                    if (tempSum <= blackJack && tempSum > sum) {
                        sum = tempSum;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static int otherSolution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cardCount = Integer.parseInt(st.nextToken());
        int blackJack = Integer.parseInt(st.nextToken());


        int[] cards = new int[cardCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int sum = 0;
        for (int i = 0; i < cardCount - 2; i++) {
            for (int j= i + 1; j < cardCount - 1; j++) {
                int fixedSum = cards[i] + cards[j];
                int remain = blackJack - fixedSum;
                int left = j + 1;
                int right = cardCount - 1;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if (cards[mid] <= remain) {
                        int tempSum = fixedSum + cards[mid];
                        if (tempSum <= blackJack && tempSum > sum) {
                            sum = tempSum;
                        }
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                }
            }
        }

        return sum;
    }
}
