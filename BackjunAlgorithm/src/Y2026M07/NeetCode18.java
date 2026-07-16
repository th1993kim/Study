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


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char value = board[i][j];
                    if (!Character.isDigit(value)) continue;
                    if (rowSetArr[i].contains(value)) return false;
                    rowSetArr[i].add(value);

                    if (colSetArr[j].contains(value)) return false;
                    colSetArr[j].add(value);

                    int boxKey = (i / 3) * 3 + (j / 3);
                    if (boxSetArr[boxKey].contains(value)) return false;
                    boxSetArr[boxKey].add(value);
                }
            }
            return true;
        }
    }
}
