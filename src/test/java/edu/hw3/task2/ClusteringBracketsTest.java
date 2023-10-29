package edu.hw3.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ClusteringBracketsTest {
    @Test
    public void whenStringHasSeveralPairsOfBracketsShouldReturnClustersWithThesePairs() {
        assertThat(ClusteringBrackets.clusterize("()()()")).isEqualTo(List.of("()", "()", "()"));
    }

    @Test
    public void whenStringHasOneClusterOfBracketsShouldReturnThisCluster() {
        assertThat(ClusteringBrackets.clusterize("((()))")).isEqualTo(List.of("((()))"));
    }

    @Test
    public void whenStringHasClustersOfBracketsShouldReturnTheseClusters() {
        assertThat(ClusteringBrackets.clusterize("((()))(())()()(()())")).isEqualTo(List.of("((()))", "(())", "()", "()", "(()())"));
        assertThat(ClusteringBrackets.clusterize("((())())(()(()()))")).isEqualTo(List.of("((())())", "(()(()()))"));
    }

    @Test
    public void whenStringHasNotBracketsCharsShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ClusteringBrackets.clusterize("()qwerty123");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ClusteringBrackets.clusterize(",(())!@");
        });
    }

    @Test
    public void whenStringHasUnbalancedBracketsShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ClusteringBrackets.clusterize("((()");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ClusteringBrackets.clusterize("()())");
        });
    }
}
