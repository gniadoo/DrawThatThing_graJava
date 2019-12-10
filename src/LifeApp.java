import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class LifeApp {

    private LifePanel lp;
    private JButton goBtn;
    private JButton clearBtn;
    private JButton resetBtn;

    public static void main(String[] args) { LifeApp a = new LifeApp();}

    public LifeApp() { buildGUI(); }

    final void buildGUI() {

        JFrame f = new JFrame("Life");


        goBtn = new JButton("Go!");

        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        lp = new LifePanel();

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(goBtn);
        ctrlPanel.add(clearBtn);

        f.add(lp, BorderLayout.CENTER);
        f.add(ctrlPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
