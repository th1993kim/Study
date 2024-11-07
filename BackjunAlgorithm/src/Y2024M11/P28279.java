package Y2024M11;

import java.io.*;
import java.util.StringTokenizer;

public class P28279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int command = Integer.parseInt(br.readLine());

        Deck deck = new Deck(100000);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "1": deck.pushTop(Integer.parseInt(st.nextToken())); break;
                case "2": deck.pushBottom(Integer.parseInt(st.nextToken())); break;
                case "3": sb.append(deck.popTop()).append("\n"); break;
                case "4" : sb.append(deck.popBottom()).append("\n"); break;
                case "5": sb.append(deck.size()).append("\n"); break;
                case "6": sb.append(deck.isEmpty() ? 1 : 0).append("\n"); break;
                case "7": sb.append(deck.printTop()).append("\n"); break;
                case "8": sb.append(deck.printBottom()).append("\n"); break;
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    private static class Deck {
        int top;
        int bottom;
        int deckSize = 0;
        int[] deck;

        public Deck(int size) {
            deck = new int[size];
            if (size == 1) {
                top = 0;
                bottom = 0;
            } else {
                top = size / 2;
                bottom = top - 1;
            }
        }

        public void pushTop(int n) {
            deck[top++] = n;
            deckSize++;
        }

        public void pushBottom(int n) {
            deck[bottom--] = n;
            deckSize++;
        }

        public int popTop() {
            if (isEmpty()) return -1;

            deckSize--;
            return deck[--top];
        }

        public int popBottom() {
            if (isEmpty()) return -1;

            deckSize--;
            return deck[++bottom];
        }

        public boolean isEmpty() {
            return deckSize == 0;
        }

        public int size() {
            return deckSize;
        }

        public int printTop() {
            if (isEmpty()) return -1;

            return deck[top - 1];
        }

        public int printBottom() {
            if (isEmpty()) return -1;

            return deck[bottom + 1];
        }

    }
}
