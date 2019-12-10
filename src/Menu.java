import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu {

    private JPanel lp1;

    private JButton game;
    private JButton ranking;
    private JButton exit;

    public static void main(String[] args) { Game a = new Game();}

    public Menu() { buildGUI(); }

    final void buildGUI() {

        JFrame f = new JFrame("Draw that thing");


        game = new JButton("New game");
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ranking = new JButton("Ranking");
        ranking.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



        JPanel ctrlPanel = new JPanel(new GridLayout(3, 1));
        ctrlPanel.add(game);
        ctrlPanel.add(ranking);
        ctrlPanel.add(exit);

        f.add(ctrlPanel, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}

