package edu.project2;

import java.util.Random;

public interface Generator {
    Random RANDOM = new Random();

    Maze generate(int height, int width);
}
