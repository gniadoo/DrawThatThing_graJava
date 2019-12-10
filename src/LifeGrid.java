public class LifeGrid {

    int dimX = 20;
    int dimY = 20;
    boolean[][] grid = new boolean[dimX][dimY];

    public LifeGrid(int x, int y) {
        dimX = x;
        dimY = y;
        grid = new boolean[dimX][dimY];
    }

    public void setSquare(int x, int y) {
        grid[x][y] = true;
        grid[5][5] = true;
        grid[5][6] = true;
        grid[5][7] = true;
        grid[5][8] = true;
        grid[5][9] = true;
        grid[6][7] = true;
        grid[7][7] = true;
        grid[7][6] = true;
        grid[7][5] = true;
        grid[7][8] = true;
        grid[7][9] = true;
    }

    public boolean getSquare(int x, int y){
        return grid[x][y];
    }


}