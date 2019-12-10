public class Grid {

    int dimX ;
    int dimY ;
    boolean[][] grid = new boolean[dimX][dimY];


    public Grid(int x, int y) {
        dimX = x;
        dimY = y;
        grid = new boolean[dimX][dimY];
    }


    public void setSquare(int x, int y) {
        grid[x][y] = true;

    }

    public boolean getSquare(int x, int y){
        return grid[x][y];
    }


}