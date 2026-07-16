package Y2026M07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NeetCode18 {

    static class Solution {
        public boolean isValidSudoku(char[][] board) {


            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            Map<Integer, Set<Integer>> boxMap = new HashMap<>();


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char value = board[i][j];
                    if (!Character.isDigit(value)) continue;
                    int number = Integer.parseInt(String.valueOf(value));
                    Set<Integer> rowSet = rowMap.get(i);
                    if (rowSet == null) {
                        rowSet = new HashSet<>();
                        rowMap.put(i, rowSet);
                    }
                    if (rowSet.contains(number)) return false;
                    rowSet.add(number);

                    Set<Integer> colSet = colMap.get(j);
                    if (colSet == null) {
                        colSet = new HashSet<>();
                        colMap.put(j, colSet);
                    }
                    if (colSet.contains(number)) return false;
                    colSet.add(number);


                    int boxKey = (i / 3) * 3 + j / 3;
                    Set<Integer> boxSet = boxMap.get(boxKey);

                    if (boxSet == null) {
                        boxSet = new HashSet<>();
                        boxMap.put(boxKey, boxSet);
                    }

                    if (boxSet.contains(number)) return false;
                    boxSet.add(number);
                }
            }
            return true;
        }
    }
}
