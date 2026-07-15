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
            while (lt < rt) {
                while(lt < rt && !Character.isLetterOrDigit(s.charAt(lt))){
                    lt++;
                }

                while(lt < rt && !Character.isLetterOrDigit(s.charAt(rt))) {
                    rt --;
                }

                if (Character.toUpperCase(s.charAt(lt)) != Character.toUpperCase(s.charAt(rt))) {
                    return false;
                }
                lt++;
                rt--;
            }

            return true;
        }
    }

}
