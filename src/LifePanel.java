import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class LifePanel extends JPanel {

    private int squareLen = 20;
    private int sizeX = 37;
    private int sizeY = 21;
    private LifeGrid lg = new LifeGrid(sizeX, sizeY);
    private LifeGrid savedGrid = lg;

    public LifePanel() {
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
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, lg.dimX * squareLen, lg.dimY * squareLen);

        // draw filled squares
        g2.setColor(Color.BLUE);
        for (int x = 0; x < lg.dimX; x++) {
            for (int y = 0; y < lg.dimY; y++) {
                if (lg.getSquare(x, y)) {
                    g2.fillRect(x * squareLen, y * squareLen, squareLen, squareLen);
                }
            }
        }
    }


    class GridClickListener extends MouseAdapter {

        private int lastUpdatedX = 0;
        private int lastUpdatedY = 0;
        private int gridX;
        private int gridY;
        private boolean adding = true;

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