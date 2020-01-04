import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GridPanel extends JPanel {

    private int sideLen = 20; // długość boku jednego kwadratowego fragmentu gridu
    private int sizeX = 40; // szerokość gridu
    private int sizeY = 32; // wysokość gridu
    boolean if_next_letter = true; // zmienna zapewniająca przeskoczenie na następną literke po poprawnym odrysowaniu
    public static int letter_number = 1; // numer kolejnej literki
    private Grid grd;

    public GridPanel(int letter_number) {
        grd = new Grid(sizeX, sizeY, letter_number);
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
                if (grd.getSquareforLetter(x, y)) {                              // pętla rysująca wcześniej zaprojektowany kształt literki na gridzie
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x * sideLen, y * sideLen, sideLen, sideLen);
                }
            }
        }

        int p = 0;
        for (int x = 0; x < grd.dimX; x++) {
            for (int y = 0; y < grd.dimY; y++) {
                if (grd.getSquarebyUser(x, y)) {                                // pętla rysująca zamalowywująca elementu gridu wskazane przez gracza
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x * sideLen, y * sideLen, sideLen, sideLen);
                }
                if (grd.getSquarebyUser(x, y) != grd.getSquareforLetter(x, y)) { // sprawdzanie czy kształt zadany pokrywa się z tym narysowanym przez gracza
                    p++;
                }
            }
        }

        if(p==0 && if_next_letter){
            if_next_letter = false;
            letter_number = letter_number +1;  // przeskakiwanie na nastepną literke jeśli kształt został odrysowany poprawnie

            Game game_frame = new Game(letter_number);
            game_frame.setVisible(true);
        }
    }

    class GridClickListener extends MouseAdapter {  // odczytywanie ruchów jakie gracz wykonał za pomocą myszy

        private int gridX;
        private int gridY;

        @Override
        public void mousePressed(MouseEvent e) { // zapewnienie rysowaniu przy klikaniu myszą
            setGridXY(e);
            switchSquare(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) { // zapewnienie rysowania przy przeciągniu myszy
            setGridXY(e);
            switchSquare(e);
        }

        private void switchSquare(MouseEvent e) { // sprawdzenie elementu klikniętego
            grd.setSquare(gridX, gridY);
            repaint();
        }

        private void setGridXY(MouseEvent e) { // zapewnienie że kliknięcie w dowolnym miejscu elementu na gridzie zapewni jego zamalowanie
            gridX = e.getX() / sideLen;
            gridY = e.getY() / sideLen;
        }

    }
}



