import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class GridPanel extends JPanel {

    private int sideLen = 20; // długość boku jednego kwadratowego fragmentu gridu
    private int sizeX = 40; // szerokość gridu
    private int sizeY = 32; // wysokość gridu
    boolean if_next_letter = true; // zmienna zapewniająca przeskoczenie na następną literke po poprawnym odrysowaniu
    boolean if_end = true; // zmiena zapobiegająca pojawieniu się kilku okienek podsumowujących po zakończeniu gry
    public int letter_number = 1; // numer kolejnej literki
    public Grid grd;

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

         if(if_next_letter && letter_number >= 5) // sprawdzenie czy zostały już narysowane wszystkie litery
            {
                if(if_end) {
                    End end_screen = null;
                    try {
                        end_screen = new End(Game.gameTime); // jeśli warunek spełniony to wyświetl ekran podsumowujący
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    end_screen.setVisible(true);

                    if_end = false;
                }

        } else if(p==0 && letter_number<5){
             letter_number = letter_number +1;  // przeskakiwanie na nastepną literke jeśli kształt został odrysowany poprawnie
             grd = new Grid(sizeX, sizeY, letter_number);
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



