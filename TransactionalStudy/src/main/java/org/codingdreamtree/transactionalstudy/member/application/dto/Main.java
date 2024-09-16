package org.codingdreamtree.transactionalstudy.member.application.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] correctChess = {1, 1, 2, 2, 2, 8};
        int[] inputChess = new int[correctChess.length];
        int index = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line = br.readLine()) != null) {
            inputChess[index++] = Integer.parseInt(line);
        }

        for (int i = 0; i < correctChess.length; i++) {
            System.out.println(correctChess[i] - inputChess[i] + " ");
        }

    }
}