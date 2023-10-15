package edu.hw1;

public class Task8_KnightsOnBoard {
    private static final int BOARD_LEN = 8;

    public static boolean knightBoardCapture(int[][] board) throws IllegalArgumentException {
        // Проверка на то, что размер переданного двумерного массива 8х8
        if (board.length != BOARD_LEN) {
            throw new IllegalArgumentException("Invalid board size. Expected 8x8 board.");
        }
        for (int[] row : board) {
            if (row.length != BOARD_LEN) {
                throw new IllegalArgumentException("Invalid board size. Expected 8x8 board.");
            }
        }

        // Проверка всех клеток. Восьмая горизонталь автоматически проверится во время проверки 6-й и 7-й
        for (int i = 1; i <= 7; ++i) {
            if (!checkKnightHorizontal(board, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkKnightHorizontal(int[][] board, int horizontal) {
        int indHor = horizontal - 1;

        if (indHor != BOARD_LEN - 2) {
            // Проверка двух крайних левых клеток
            if (board[indHor][0] == 1 && (board[indHor + 2][1] == 1 || board[indHor + 1][2] == 1)) {
                return false;
            }
            if (board[indHor][1] == 1 &&
                (board[indHor + 2][0] == 1 || board[indHor + 2][2] == 1 || board[indHor + 1][3] == 1)) {
                return false;
            }

            // Проверка четырех центральных клеток
            for (int j = 2; j < BOARD_LEN - 2; ++j) {
                if (board[indHor][j] == 1 && (board[indHor + 2][j - 1] == 1 || board[indHor + 2][j + 1] == 1 ||
                    board[indHor + 1][j - 2] == 1 || board[indHor + 1][j + 2] == 1)) {
                    return false;
                }
            }

            // Проверка двух крайних правых клеток
            if (board[indHor][BOARD_LEN - 2] == 1 &&
                (board[indHor + 2][BOARD_LEN - 3] == 1 || board[indHor + 2][BOARD_LEN - 1] == 1
                    || board[indHor + 1][BOARD_LEN - 4] == 1)) {
                return false;
            }
            if (board[indHor][BOARD_LEN - 1] == 1 &&
                (board[indHor + 2][BOARD_LEN - 2] == 1 || board[indHor + 1][BOARD_LEN - 3] == 1)) {
                return false;
            }
        } else {
            // Проверка двух крайних левых клеток седьмой горизонтали
            for (int i = 0; i < 1; ++i) {
                if (board[indHor][i] == 1 && board[BOARD_LEN - 1][i + 2] == 1) {
                    return false;
                }
            }

            // Проверка четырех центральных клеток седьмой горизонтали
            for (int j = 2; j < BOARD_LEN - 2; ++j) {
                if (board[indHor][j] == 1 && (board[BOARD_LEN - 1][j - 2] == 1 || board[BOARD_LEN - 1][j + 2] == 1)) {
                    return false;
                }
            }

            // Проверка двух крайних правых клеток седьмой горизонтали
            for (int i = BOARD_LEN - 2; i < BOARD_LEN - 1; ++i) {
                if (board[indHor][i] == 1 && board[BOARD_LEN - 1][i - 2] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
