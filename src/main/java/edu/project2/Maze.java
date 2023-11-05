package edu.project2;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(new Coordinate(row, col), Cell.Type.WALL);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    Cell[][] getGrid() {
        return grid;
    }

    Cell getCell(Coordinate coordinate) {
        return grid[coordinate.row()][coordinate.col()];
    }

    void setCell(Coordinate coordinate, Cell.Type type) {
        grid[coordinate.row()][coordinate.col()] = new Cell(coordinate, type);
    }

    public boolean isValidLocation(Coordinate coordinate) {
        return coordinate.row() >= 0 && coordinate.row() <= height - 1
            && coordinate.col() >= 0 && coordinate.col() <= width - 1;
    }

    public boolean isWall(Coordinate coordinate) {
        return grid[coordinate.row()][coordinate.col()].type().equals(Cell.Type.WALL);
    }
}
