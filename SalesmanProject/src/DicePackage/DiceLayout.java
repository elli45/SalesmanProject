package DicePackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class DiceLayout extends Canvas {

    int start_x = 740;
    int start_y = 200;

    public static int dice_size = 130;

    public DiceLayout(JFrame frame) {
        Random rand = new Random();

        ImageIcon icon6 = new ImageIcon("Assets/" + 6 + ".png");
        JButton b = new JButton(icon6);
        b.setBounds(start_x, start_y, dice_size, dice_size);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int int_random = rand.nextInt(6) + 1;
                ImageIcon icon = new ImageIcon("Assets/" + int_random + ".png");
                b.setIcon(icon);
            }
        });

        frame.add(b);
    }
}