package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class ClusteringBrackets {
    private static final String UNBALANCED_BRACKETS_MSG = "Unbalanced brackets!";
    private static final String NOT_BRACKETS_CHARS_MSG =
        "Input string must not contain characters other than brackets!";

    private ClusteringBrackets() {
    }

    public static List<String> clusterize(String brackets) {
        List<String> clusters = new ArrayList<>();

        Stack<Character> openingBrackets = new Stack<>();
        StringBuilder currentCluster = new StringBuilder();

        for (char bracket : brackets.toCharArray()) {
            if (bracket != '(' && bracket != ')') {
                throw new IllegalArgumentException(NOT_BRACKETS_CHARS_MSG);
            }

            if (bracket == '(') {
                if (openingBrackets.empty() && !currentCluster.isEmpty()) {
                    clusters.add(currentCluster.toString());
                    currentCluster = new StringBuilder();
                }
                openingBrackets.push(bracket);
            } else { // bracket == ')'
                if (openingBrackets.empty()) {
                    throw new IllegalArgumentException(UNBALANCED_BRACKETS_MSG);
                }

                if (!openingBrackets.empty()) {
                    openingBrackets.pop();
                }
            }

            currentCluster.append(bracket);
        }

        if (openingBrackets.empty()) {
            clusters.add(currentCluster.toString());
        } else {
            throw new IllegalArgumentException(UNBALANCED_BRACKETS_MSG);
        }

        return clusters;
    }
}
