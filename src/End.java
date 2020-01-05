import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class End {

    private JButton menu;
    JFrame end_screen = new JFrame("Draw that thing");

    public End(int time) throws IOException {

        menu = new JButton("EXIT");
        menu.addActionListener(e ->{
            end_screen.setVisible(false);

        });

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);

        JLabel congrats = new JLabel("Congratulations! You have finished game in");
        JLabel theme = new JLabel(String.valueOf(time) + " seconds"); // wypisanie czasu rozgrywki
        JPanel list = new JPanel();
        list.setPreferredSize(new Dimension(300,300));
        list.add(congrats);
        list.add(theme);

        FileWriter fr = new FileWriter("wyniki.txt", true); //
        fr.write("\n");                                                  // zapisywanie kolejnych czasów rozgrywki do pliku
        fr.write(String.valueOf(time) + " seconds");                     // w oddzielnych liniach
        fr.close();                                                          //

        end_screen.add(list);
        end_screen.add(ctrlPanel, BorderLayout.SOUTH);
        end_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        end_screen.pack();
        end_screen.setPreferredSize(new Dimension(500, 500));

    }

    public void setVisible(boolean b) {
        end_screen.setVisible(true);
    }

}
