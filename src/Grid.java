public class Grid {

    int dimX ;
    int dimY ;
    boolean[][] byUser;
    boolean[][] letter_shape;
    int n;

    public Grid(int x, int y, int temp) {
        dimX = x;
        dimY = y;
        n = temp;
        byUser = new boolean[dimX][dimY];
        letter_shape = new boolean[dimX][dimY];

        switch (temp) {
            case 1:
                letter_shape[20][10] = true;
                letter_shape[21][10] = true;
                break;
            case 2:
                letter_shape[16][8] = true;
                letter_shape[16][9] = true;
                letter_shape[16][10] = true;
                letter_shape[16][11] = true;
                letter_shape[16][12] = true;
                letter_shape[16][13] = true;
                letter_shape[16][14] = true;
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
                letter_shape[17][8] = true;
                letter_shape[18][8] = true;
                letter_shape[19][8] = true;
                letter_shape[20][8] = true;
                letter_shape[17][25] = true;
                letter_shape[18][25] = true;
                letter_shape[19][25] = true;
                letter_shape[20][9] = true;
                letter_shape[21][10] = true;
                letter_shape[22][10] = true;
                letter_shape[21][9] = true;
                letter_shape[23][11] = true;
                letter_shape[23][12] = true;
                letter_shape[23][13] = true;
                letter_shape[22][14] = true;
                letter_shape[21][15] = true;
                letter_shape[20][16] = true;
                letter_shape[19][16] = true;
                letter_shape[18][16] = true;
                letter_shape[17][16] = true;
                letter_shape[21][17] = true;
                letter_shape[22][17] = true;
                letter_shape[23][18] = true;
                letter_shape[24][19] = true;
                letter_shape[24][20] = true;
                letter_shape[24][21] = true;
                letter_shape[24][22] = true;
                letter_shape[24][23] = true;
                letter_shape[23][24] = true;
                letter_shape[22][25] = true;
                letter_shape[21][25] = true;
                letter_shape[20][25] = true;
                break;
        }

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