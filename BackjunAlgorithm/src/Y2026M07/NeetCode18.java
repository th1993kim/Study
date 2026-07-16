package Y2026M07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NeetCode18 {

    static class Solution {
        public boolean isValidSudoku(char[][] board) {


            Set<Character>[] rowSetArr = new HashSet[9];
            Set<Character>[] colSetArr = new HashSet[9];
            Set<Character>[] boxSetArr = new HashSet[9];

            for (int i = 0 ; i < 9; i++) {
                rowSetArr[i] = new HashSet<>();
                colSetArr[i] = new HashSet<>();
                boxSetArr[i] = new HashSet<>();
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char value = board[i][j];
                    if (!Character.isDigit(value)) continue;
                    if (!rowSetArr[i].add(value)) return false;
                    if (colSetArr[j].add(value)) return false;
                    int boxKey = (i / 3) * 3 + (j / 3);
                    if (boxSetArr[boxKey].add(value)) return false;
                }
            }
            return true;
        }
    }
}
