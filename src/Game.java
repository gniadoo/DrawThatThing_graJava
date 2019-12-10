import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

    private GridPanel lp;
    private JButton menu;

    public Game() { buildGUI(); }
    JFrame f = new JFrame("Life");


    final void buildGUI() {
        menu = new JButton("Menu");

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });

        lp = new GridPanel();

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);

        f.add(lp, BorderLayout.CENTER);
        f.add(ctrlPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setPreferredSize(new Dimension(800, 700));
    }

    public void setVisible(boolean b) {
        f.setVisible(true);
    }
}
