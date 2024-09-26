package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        /* 현재 체스 판을 입력받는다. */
        char[][] chess = new char[n][m];
        for (int i=0; i<n; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        /* 해당 N * M 배열의 W로 시작하는 체스판과, B로 시작하는 체스판을 만든다. */
        char[][] wStartArray = createChessArray(n, m, 'W', 'B');
        char[][] bStartArray = createChessArray(n, m, 'B', 'W');

        /* 입력받은 체스판과 위의 생성한 올바르게 정렬되어있는 체스판을 비교한 판을 만든다. */
        int[][] compareWStartArray = compareStartArray(chess, wStartArray);
        int[][] compareBStartArray = compareStartArray(chess, bStartArray);


        /* 8*8 배열을 순회하면서 체스한판의 비교값들을 SUM 하고, 최소값 비교를 한다. (W시작판과 B시작판 비교배열값) */
        int minimumW = Integer.MAX_VALUE;
        int minimumB = Integer.MAX_VALUE;
        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                int tempSumW = 0;
                int tempSumB = 0;
                for(int k=i; k<i+8; k++) {
                    for(int l=j; l<j+8; l++) {
                        tempSumW += compareWStartArray[k][l];
                        tempSumB += compareBStartArray[k][l];
                    }

                }
                if (tempSumW < minimumW) {
                    minimumW = tempSumW;
                }
                if (tempSumB < minimumB) {
                    minimumB = tempSumB;
                }
            }
        }

        System.out.println(Math.min(minimumB, minimumW));
    }

    private static int[][] compareStartArray(char[][] chess, char[][] startArray) {
        int n = chess.length;
        int m = chess[0].length;
        int[][] compareArray = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (chess[i][j] != startArray[i][j]) {
                    compareArray[i][j] = 1;
                }
            }
        }
        return compareArray;
    }

    private static char[][] createChessArray(int n, int m, char startChar, char otherChar) {

        char[][] chess = new char[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        chess[i][j] = startChar;
                    } else {
                        chess[i][j] = otherChar;
                    }
                } else {
                    if (j % 2 == 0) {
                        chess[i][j] = otherChar;
                    } else {
                        chess[i][j] = startChar;
                    }
                }
            }
        }

        return chess;
    }


    private static int otherSolution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        /* 현재 체스 판을 입력받는다. */
        char[][] chess = new char[n][m];
        for (int i=0; i<n; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        /* 8*8 배열을 순회하면서 체스한판의 비교값들을 SUM 하고, 최소값 비교를 한다. */
        int minimum = Integer.MAX_VALUE; //최솟값을 구하기 위해 최대값을 지정해준다.
        int allChessCount = 64; //체스 총 개수

        for (int i = 0; i < n -7; i++) {
            for (int j = 0; j < m-7; j++) {
                char startChar = chess[i][j]; //시작 문자값
                char nextChar = 'W' == startChar ? 'B' : 'W'; //다음 문자값
                int changeColorCount = 0;
                for (int k = 0; k < i + 8; k++) {
                    for (int l = 0; l < j + 8; j++) {
                        char expectedChar = (k+l) % 2 == 0 ? startChar : nextChar; //짝수열일때는 시작문자와 같은 문자를 가져야함, 홀수열일때는 다음문자값을 가져야함
                        if (chess[k][l] != expectedChar) {
                            changeColorCount++;
                        }
                    }
                }
                Math.min(changeColorCount, allChessCount - changeColorCount); //첫 시작문자와 동일한 경우와 색이 첫 시작문자가 반대문자로 시작하는 경우를 비교한다.
                // 모든 체스 수 에서 첫 시작문자 순서로 바뀐 경우만 제외해주면 반대의 경우가 된다.
                Math.min(minimum, changeColorCount);
            }
        }
        return minimum;
    }
}
