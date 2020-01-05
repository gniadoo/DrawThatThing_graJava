import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Ranking {

    private JButton menu;
    JFrame ranking = new JFrame("Draw that thing");

    public Ranking() throws FileNotFoundException {

        menu = new JButton("Menu");
        menu.addActionListener(e -> ranking.setVisible(false));

        JPanel ctrlPanel = new JPanel(new GridLayout(1, 4));
        ctrlPanel.add(menu);

        JLabel theme = new JLabel("Ranking");

        JPanel list = new JPanel(new GridLayout(10, 1));  // lista na zapisane czasy rozgrywek
        list.setPreferredSize(new Dimension(800,640));
        list.add(theme);


        File openFile = new File("wyniki.txt");  // odczytanie zapisanych czasów z pliku wyniki.txt
        Scanner fileScanner = new Scanner(openFile);       //
                                                           //
        while(fileScanner.hasNextLine()){                  //
            String currentLine = fileScanner.nextLine();   // tworzenie nowych JLabel' ów i dodawanie
            JLabel temp = new JLabel(currentLine);         // ich do listy czasów jeśli istnieją
            list.add(temp);                                //
        }                                                  //
        fileScanner.close();                               //



        ranking.add(list , BorderLayout.CENTER);
        ranking.add(ctrlPanel, BorderLayout.SOUTH);
        ranking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ranking.pack();
        ranking.setPreferredSize(new Dimension(800, 700));

    }

    public void setVisible(boolean b) {
        ranking.setVisible(true);
    }


}
