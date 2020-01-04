import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;


public class Menu extends JFrame{

    public static int gameTime = 0;
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {     // czas trwania jedenj rozgrywki
        @Override
        public void run() {
            gameTime = gameTime +1;
            System.out.println(gameTime);
        }
    };

    public static void main(String[] args) { Menu a = new Menu(); }


    public Menu() {

        JFrame main_frame = new JFrame("Draw that thing");  // główne okienko programu
        JLabel label;
        Icon logoImage = new ImageIcon(getClass().getResource("back.jpg"));  // obrazek ustawiony jako tło menu głównego
        label = new JLabel(logoImage);
        label.setSize(600, 400);

        JButton game;
        JButton ranking;  // przyciski w menu głównym
        JButton exit;

        JPanel menu_panel = new JPanel(new GridLayout(3, 1));  // ułożenie przycisków w menu
        menu_panel.setPreferredSize(new Dimension(100, 90));//

        game = new JButton("New game"); // przycisko rozpoczęcia nowej gry
        game.setPreferredSize(new Dimension(40, 40));
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game_frame = new Game(1);
                game_frame.setVisible(true);
                myTimer.scheduleAtFixedRate(task,1000,1000); // rozpoczęcie pomiaru czasu
            }
        });

        ranking = new JButton("Ranking"); // przycisk wejścia do rankingu
        ranking.setPreferredSize(new Dimension(40, 40));
        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ranking ranking_frame = new Ranking();
                ranking_frame.setVisible(true);
            }
        });

        exit = new JButton("Exit"); // przycisk wyjścia z gry
        exit.setPreferredSize(new Dimension(40, 40));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu_panel.add(game);
        menu_panel.add(ranking);
        menu_panel.add(exit);
        main_frame.add(label);
        main_frame.add(menu_panel, BorderLayout.PAGE_END);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setPreferredSize(new Dimension(800, 700));
        main_frame.pack();
        main_frame.setVisible(true);
        main_frame.setResizable(false);
    }
}