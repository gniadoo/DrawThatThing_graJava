import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

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

        for (int x = 0; x < lg.dimX; x++) {
            for (int y = 0; y < lg.dimY; y++) {
                if (lg.getSquare1(x, y)) {
                    g2.setColor(Color.RED);
                    g2.fillRect(x * squareLen, y * squareLen, squareLen, squareLen);
                }
            }
        }

        int p = 0;
        for (int x = 0; x < lg.dimX; x++) {
            for (int y = 0; y < lg.dimY; y++) {
                if (lg.getSquare(x, y)) {
                    g2.setColor(Color.BLUE);
                    g2.fillRect(x * squareLen, y * squareLen, squareLen, squareLen);
                }
                if (lg.getSquare(x, y) != lg.getSquare1(x, y)) {
                    p++;
                }
            }
        }
        if(p==0){System.out.println("Brawo udało ci sie!");}
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



