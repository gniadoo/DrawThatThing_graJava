import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

    private GridPanel gp;
    private JButton menu;

    public Game() { buildGUI(); }

    JFrame main_game = new JFrame("Draw that thing");

    final void buildGUI() {

        menu = new JButton("Menu");

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_game.setVisible(false);
            }
        });

        gp = new GridPanel();

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);

        main_game.add(gp, BorderLayout.CENTER);
        main_game.add(ctrlPanel, BorderLayout.SOUTH);
        main_game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_game.pack();
        main_game.setPreferredSize(new Dimension(800, 700));
    }

    public void setVisible(boolean b) {
        main_game.setVisible(true);
    }
}
