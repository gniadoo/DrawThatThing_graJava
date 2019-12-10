import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

    private LifePanel lp;
    private JButton menu;

   public static void main(String[] args) { Game a = new Game();}

    public Game() { buildGUI(); }

    final void buildGUI() {

        JFrame f = new JFrame("Life");


        menu = new JButton("Menu");

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        lp = new LifePanel();

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);

        f.add(lp, BorderLayout.CENTER);
        f.add(ctrlPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
