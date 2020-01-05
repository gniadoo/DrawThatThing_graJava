import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

    int letter; // numer porządkowy litery według alfabetu
    private GridPanel grdPanel; // główny grid na którym odrysowuje się zadane kształty
    private JButton menu;
    public JFrame main_game = new JFrame("Draw that thing");
    static int gameTime = 0;

    public Game(int letter) {

        java.util.Timer myTimer = new Timer();

        TimerTask start = new TimerTask() {     // czas trwania jedenj rozgrywki
            @Override
            public void run() {
                gameTime = gameTime +1;
            }
        };

        menu = new JButton("Menu");

        menu.addActionListener(e -> {
            myTimer.cancel();
            main_game.setVisible(false);
            Menu a = new Menu();
            gameTime = 0;    // zerowanie pomiaru czasu jeśli w czasie rozgrywki gracz wyjdzie do menu
        });

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);
        grdPanel = new GridPanel(letter); // tworzenie gridu dla literki
        myTimer.scheduleAtFixedRate(start,1000,1000);


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
