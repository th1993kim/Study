package Y2024M11;

import java.io.*;
import java.util.*;

public class P1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<Character> leftDeque = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char charWord : word.toCharArray()) {
            leftDeque.add(charWord);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L": {
                    if (!leftDeque.isEmpty()) {
                        stack.push(leftDeque.removeLast());
                    }
                    break;
                }
                case "D": {
                    if (!stack.isEmpty()) {
                        leftDeque.addLast(stack.pop());
                    }
                    break;
                }
                case "B": {
                    if (!leftDeque.isEmpty()) {
                        leftDeque.removeLast();
                    }
                    break;
                }
                case "P": {
                    leftDeque.addLast(st.nextToken().charAt(0));
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!leftDeque.isEmpty()) {
            sb.append(leftDeque.removeFirst());
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
    
    
    private static void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        String word = br.readLine();
        int n = Integer.parseInt(br.readLine());

        LinkedList<Character> characterLinkedList = new LinkedList<>();
        for (char charWord : word.toCharArray()) {
            characterLinkedList.add(charWord);
        }
        ListIterator<Character> iterator = characterLinkedList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "L": {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                }
                case "D": {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                }
                case "B": {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                }
                case "P": {
                    iterator.add(st.nextToken().charAt(0));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : characterLinkedList) {
            sb.append(character);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
