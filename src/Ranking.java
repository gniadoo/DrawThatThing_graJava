import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Ranking {

    private JButton menu;
    JFrame ranking = new JFrame("Draw that thing");


    public Ranking() {


        menu = new JButton("Menu");
        menu.addActionListener(e -> ranking.setVisible(false));


        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);
        JLabel theme = new JLabel("Ranking");
        JPanel list = new JPanel();
        list.setPreferredSize(new Dimension(800,640));
        list.add(theme);


        ranking.add(list);
        ranking.add(ctrlPanel, BorderLayout.SOUTH);
        ranking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ranking.pack();
        ranking.setPreferredSize(new Dimension(800, 700));

    }

    public void setVisible(boolean b) {
        ranking.setVisible(true);
    }
}
