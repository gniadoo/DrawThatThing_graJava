import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static java.awt.FlowLayout.CENTER;

public class Menu extends JFrame{

    Game f2 = new Game();
    public static void main(String[] args) { Menu a = new Menu();}

    public Menu() {

        JFrame f1 = new JFrame("Draw that thing");

        JLabel label;
        Icon logoImage = new ImageIcon(getClass().getResource("back.jpg"));
        label = new JLabel(logoImage);
        label.setSize(600, 400);


        JButton game;
        JButton ranking;
        JButton exit;
        Container content = getContentPane();
        content.setLayout(new GridLayout(4,1));
        JPanel menupanel = new JPanel(new GridLayout(3, 1));
        menupanel.setPreferredSize(new Dimension(100, 90));

        game = new JButton("New game");
        game.setPreferredSize(new Dimension(40, 40));
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game f2 = new Game();
                f2.setVisible(true);
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
                f1.setVisible(false);
            }
        });

        menupanel.add(game);
        menupanel.add(ranking);
        menupanel.add(exit);
        //menupanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));


        f1.add(label);
        f1.add(menupanel, BorderLayout.PAGE_END);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setPreferredSize(new Dimension(800, 700));
        f1.pack();
        f1.setVisible(true);
        f1.setResizable(false);
    }
}