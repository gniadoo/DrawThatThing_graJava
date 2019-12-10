public class Grid {

    int dimX ;
    int dimY ;
    boolean[][] byUser;
    boolean[][] letter_shape;

    public Grid(int x, int y) {
        dimX = x;
        dimY = y;
        byUser = new boolean[dimX][dimY];
        letter_shape = new boolean[dimX][dimY];
        letter_shape[20][10] = true;
        letter_shape[21][10] = true;
        letter_shape[19][11] = true;
        letter_shape[22][11] = true;
        letter_shape[18][12] = true;
        letter_shape[23][12] = true;
        letter_shape[17][13] = true;
        letter_shape[24][13] = true;
        letter_shape[16][14] = true;
        letter_shape[25][14] = true;
        letter_shape[16][15] = true;
        letter_shape[16][16] = true;
        letter_shape[16][17] = true;
        letter_shape[16][18] = true;
        letter_shape[16][19] = true;
        letter_shape[16][20] = true;
        letter_shape[16][21] = true;
        letter_shape[16][22] = true;
        letter_shape[16][23] = true;
        letter_shape[16][24] = true;
        letter_shape[16][25] = true;
        letter_shape[25][15] = true;
        letter_shape[25][16] = true;
        letter_shape[25][17] = true;
        letter_shape[25][18] = true;
        letter_shape[25][19] = true;
        letter_shape[25][20] = true;
        letter_shape[25][21] = true;
        letter_shape[25][22] = true;
        letter_shape[25][23] = true;
        letter_shape[25][24] = true;
        letter_shape[25][25] = true;
        letter_shape[17][16] = true;
        letter_shape[18][16] = true;
        letter_shape[19][16] = true;
        letter_shape[20][16] = true;
        letter_shape[21][16] = true;
        letter_shape[22][16] = true;
        letter_shape[23][16] = true;
        letter_shape[24][16] = true;
        letter_shape[18][11] = true;
        letter_shape[23][11] = true;
        letter_shape[17][12] = true;
        letter_shape[16][13] = true;
        letter_shape[24][12] = true;
        letter_shape[25][13] = true;
        letter_shape[19][10] = true;
        letter_shape[22][10] = true;
    }

    public void setSquare(int x, int y) {
        if(byUser[x][y] != letter_shape[x][y]){
            byUser[x][y] = true;
        }

    }

    public boolean getSquarebyUser(int x, int y){
        return byUser[x][y];
    }

    public boolean getSquareforLetter(int x, int y){
        return letter_shape[x][y];

    }
}