import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class GridPanel extends JPanel {

    private int sideLen = 20;
    private int sizeX = 40;
    private int sizeY = 32;
    boolean ewelona = true;
    int n = 1;
    private Grid grd = new Grid(sizeX, sizeY, n);

    public GridPanel(int n) {
        grd = new Grid(sizeX, sizeY, n);
        setPreferredSize(new Dimension(sideLen * sizeX, sideLen * sizeY));
        GridClickListener gcl = new GridClickListener();
        addMouseListener(gcl);
        addMouseMotionListener(gcl);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, grd.dimX * sideLen, grd.dimY * sideLen);

        for (int x = 0; x < grd.dimX; x++) {
            for (int y = 0; y < grd.dimY; y++) {
                if (grd.getSquareforLetter(x, y)) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x * sideLen, y * sideLen, sideLen, sideLen);
                }
            }
        }

        int p = 0;
        for (int x = 0; x < grd.dimX; x++) {
            for (int y = 0; y < grd.dimY; y++) {
                if (grd.getSquarebyUser(x, y)) {
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x * sideLen, y * sideLen, sideLen, sideLen);
                }
                if (grd.getSquarebyUser(x, y) != grd.getSquareforLetter(x, y)) {

                    p++;

                }
            }
        }

        if(p==0 && ewelona){
            ewelona = false;
            n=n+1;

            Game game_frame = new Game(n);
            game_frame.setVisible(true);

        }
    }

    class GridClickListener extends MouseAdapter {

        private int gridX;
        private int gridY;

        @Override
        public void mousePressed(MouseEvent e) {
            setGridXY(e);
            switchSquare(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            setGridXY(e);
            switchSquare(e);
        }

        private void switchSquare(MouseEvent e) {
            grd.setSquare(gridX, gridY);
            repaint();
        }

        private void setGridXY(MouseEvent e) {
            gridX = e.getX() / sideLen;
            gridY = e.getY() / sideLen;
        }

    }
}



