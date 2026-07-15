package Y2026M07;

public class NeetCode10 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome("Was it a car or a cat I saw?");
    }
    static class Solution {
        public boolean isPalindrome(String s) {

            int lt = 0;
            int rt = s.length() - 1;
            String upperCase = s.toUpperCase();
            while (lt <= rt) {
                if (!Character.isAlphabetic(upperCase.charAt(lt)) && !Character.isDigit(upperCase.charAt(lt))) {
                    lt++;
                    continue;
                }

                if (!Character.isAlphabetic(upperCase.charAt(rt)) && !Character.isDigit(upperCase.charAt(rt))) {
                    rt --;
                    continue;
                }

                if (upperCase.charAt(lt) != upperCase.charAt(rt)) {
                    return false;
                }
                lt++;
                rt--;
            }

            return true;
        }
    }

}
