package Y2026M08;

public class LeetCode115 {
    static class Solution {
        public String intToRoman(int num) {
            Roman[] romans = new Roman[] {
                    new Roman("M", 1000),
                    new Roman("CM", 900),
                    new Roman("D", 500),
                    new Roman("CD", 400),
                    new Roman("C", 100),
                    new Roman("XC", 90),
                    new Roman("L", 50),
                    new Roman("XL", 40),
                    new Roman("X", 10),
                    new Roman("IX", 9),
                    new Roman("V", 5),
                    new Roman("IV", 4),
                    new Roman("I", 1)
            };

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < romans.length; i++) {
                while (num - romans[i].value >= 0) {
                    num -= romans[i].value;
                    sb.append(romans[i].word);
                }
            }

            return sb.toString();
        }

        private static class Roman {
            private final String word;
            private final int value;

            public Roman(String word, int value) {
                this.word = word;
                this.value = value;
            }
        }
    }
}
