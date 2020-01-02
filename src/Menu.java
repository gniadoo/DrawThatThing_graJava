import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Menu extends JFrame{

    public static void main(String[] args) { Menu a = new Menu(); }

    public Menu() {

        JFrame main_frame = new JFrame("Draw that thing");

        JLabel label;
        Icon logoImage = new ImageIcon(getClass().getResource("back.jpg"));
        label = new JLabel(logoImage);
        label.setSize(600, 400);

        JButton game;
        JButton ranking;
        JButton exit;

        JPanel menu_panel = new JPanel(new GridLayout(3, 1));
        menu_panel.setPreferredSize(new Dimension(100, 90));

        game = new JButton("New game");
        game.setPreferredSize(new Dimension(40, 40));
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game_frame = new Game(1);
                game_frame.setVisible(true);
            }
        });

        ranking = new JButton("Ranking");
        ranking.setPreferredSize(new Dimension(40, 40));
        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(40, 40));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);;
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