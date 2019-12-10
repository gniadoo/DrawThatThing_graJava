public class Grid {

    int dimX ;
    int dimY ;
    boolean[][] grid = new boolean[dimX][dimY];
    boolean[][] byUser = new boolean[dimX][dimY];




    public Grid(int x, int y) {
        dimX = x;
        dimY = y;
        grid = new boolean[dimX][dimY];
        byUser = new boolean[dimX][dimY];
        byUser[20][10] = true;
        byUser[21][10] = true;
        byUser[19][11] = true;
        byUser[22][11] = true;
        byUser[18][12] = true;
        byUser[23][12] = true;
        byUser[17][13] = true;
        byUser[24][13] = true;
        byUser[16][14] = true;
        byUser[25][14] = true;
        byUser[16][15] = true;
        byUser[16][16] = true;
        byUser[16][17] = true;
        byUser[16][18] = true;
        byUser[16][19] = true;
        byUser[16][20] = true;
        byUser[16][21] = true;
        byUser[16][22] = true;
        byUser[16][23] = true;
        byUser[16][24] = true;
        byUser[16][25] = true;
        byUser[25][15] = true;
        byUser[25][16] = true;
        byUser[25][17] = true;
        byUser[25][18] = true;
        byUser[25][19] = true;
        byUser[25][20] = true;
        byUser[25][21] = true;
        byUser[25][22] = true;
        byUser[25][23] = true;
        byUser[25][24] = true;
        byUser[25][25] = true;
        byUser[17][16] = true;
        byUser[18][16] = true;
        byUser[19][16] = true;
        byUser[20][16] = true;
        byUser[21][16] = true;
        byUser[22][16] = true;
        byUser[23][16] = true;
        byUser[24][16] = true;
    }


    public void setSquare(int x, int y) {
        if(grid[x][y] != byUser[x][y]){
            grid[x][y] = true;
        }

    }

    public boolean getSquare(int x, int y){
        return grid[x][y];
    }
    public boolean getSquare1(int x, int y){
        return byUser[x][y];

    }


}