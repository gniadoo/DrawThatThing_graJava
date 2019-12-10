import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import static java.awt.Color.RED;

public class GridPanel extends JPanel {

    private int squareLen = 20;
    private int sizeX = 40;
    private int sizeY = 32;
    private Grid lg = new Grid(sizeX, sizeY);

    public GridPanel() {
        setPreferredSize(new Dimension(squareLen * sizeX, squareLen * sizeY));
        GridClickListener gcl = new GridClickListener();
        addMouseListener(gcl);
        addMouseMotionListener(gcl);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw background
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, lg.dimX * squareLen, lg.dimY * squareLen);

        // draw filled squares
        g2.setColor(RED);
        g2.fillRect(20 * squareLen, 10 * squareLen, squareLen, squareLen);          //
        g2.fillRect(21 * squareLen, 10 * squareLen, squareLen, squareLen);          //
        g2.fillRect(19 * squareLen, 11 * squareLen, squareLen, squareLen);          //
        g2.fillRect(22 * squareLen, 11 * squareLen, squareLen, squareLen);          //
        g2.fillRect(18 * squareLen, 12 * squareLen, squareLen, squareLen);          //
        g2.fillRect(23 * squareLen, 12 * squareLen, squareLen, squareLen);          //
        g2.fillRect(17 * squareLen, 13 * squareLen, squareLen, squareLen);          //łopatologiczny kod rysowania literki A na gridzie
        g2.fillRect(24 * squareLen, 13 * squareLen, squareLen, squareLen);          //
        g2.fillRect(16 * squareLen, 14 * squareLen, squareLen, squareLen);          //
        g2.fillRect(25 * squareLen, 14 * squareLen, squareLen, squareLen);          //
        g2.fillRect(16 * squareLen, 15 * squareLen, squareLen, 10*squareLen);//
        g2.fillRect(25 * squareLen, 15 * squareLen, squareLen, 10*squareLen);//
        g2.fillRect(17 * squareLen, 17 * squareLen, 8*squareLen, squareLen);  //

        for (int x = 0; x < lg.dimX; x++) {
            for (int y = 0; y < lg.dimY; y++) {
                if (lg.getSquare(x, y)) {
                    g2.setColor(Color.BLUE);
                    g2.fillRect(x * squareLen, y * squareLen, squareLen, squareLen);
                }
                //if(lg.getSquare(x, y) = RED)
            }
        }
    }


    class GridClickListener extends MouseAdapter {

        private int gridX;
        private int gridY;

        @Override
        public void mousePressed(MouseEvent e) {
            setGridXY(e);
            toggleSquare(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            setGridXY(e);
            toggleSquare(e);
        }

        private void toggleSquare(MouseEvent e) {
            lg.setSquare(gridX, gridY);
            repaint();
        }

        private void setGridXY(MouseEvent e) {
            gridX = e.getX() / squareLen;
            gridY = e.getY() / squareLen;
        }
    }
}