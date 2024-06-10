package org.codingdreamtree.awssqsstudy.message;

public record SimpleMessage(
        int pk,
        String name,
        int age,
        int score
) {
}
