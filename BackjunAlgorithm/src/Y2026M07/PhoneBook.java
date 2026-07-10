package Y2026M07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    public static void main(String[] args) {

        boolean answer = new PhoneBook().solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(answer);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> dupSet = new HashSet<>();
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (int i = 0; i < phone_book.length; i++) {
            for (String inPhone : dupSet) {
                if (phone_book[i].length() > inPhone.length()) {
                    boolean check = inPhone.equals(phone_book[i].substring(0, inPhone.length()));
                    if (check) return false;
                }
            }
            dupSet.add(phone_book[i]);
        }

        return answer;
    }
}
