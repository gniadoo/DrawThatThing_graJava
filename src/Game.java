import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Game {

    int letter; // numer porządkowy litery według alfabetu
    private GridPanel grdPanel; // główny grin na którym odrysowuje się zadane kształty
    private JButton menu;
    JFrame main_game = new JFrame("Draw that thing");

    public Game(int letter_to_draw) {
        letter = letter_to_draw; // przekazanie numery między kolejnymi ramkami wyświetlającymi kształty

        menu = new JButton("Menu");
        menu.addActionListener(e -> main_game.setVisible(false));


        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);
        grdPanel = new GridPanel(letter); // tworzenie gridu dla konkretnej literki o danym numerze

        main_game.add(grdPanel, BorderLayout.CENTER);
        main_game.add(ctrlPanel, BorderLayout.SOUTH);
        main_game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_game.pack();
        main_game.setPreferredSize(new Dimension(800, 700));

    }

    public void setVisible(boolean b) { // wyświetlanie frame
        main_game.setVisible(true);
    }
}
