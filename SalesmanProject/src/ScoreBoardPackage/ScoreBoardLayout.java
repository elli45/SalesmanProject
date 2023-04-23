package ScoreBoardPackage;

import javax.swing.*;

public class ScoreBoardLayout {
    int start_x = 750;
    int start_y = 30;

    int distance = 30;

    public ScoreBoardLayout (JFrame frame) {

        JLabel my_info, my_info_coin, my_info_power;
        JLabel op_info, op_info_coin, op_info_power;

        my_info = new JLabel("Me");
        my_info.setBounds(start_x, start_y, 100, 30);

        op_info = new JLabel("Oponent");
        op_info.setBounds(start_x+70, start_y, 100, 30);

        my_info_coin = new JLabel(new ImageIcon("Assets/coin.png"));
        my_info_coin.setBounds(start_x, start_y + distance, 15, 15);

        op_info_coin = new JLabel(new ImageIcon("Assets/coin.png"));
        op_info_coin.setBounds(start_x+90, start_y + distance, 15, 15);

        my_info_power = new JLabel(new ImageIcon("Assets/power.png"));
        my_info_power.setBounds(start_x, start_y + 2 * distance, 10, 15);

        op_info_power = new JLabel(new ImageIcon("Assets/power.png"));
        op_info_power.setBounds(start_x+90, start_y + 2 * distance, 10, 15);
        
        frame.add(my_info);
        frame.add(op_info);
        frame.add(my_info_coin);
        frame.add(op_info_coin);
        frame.add(my_info_power);
        frame.add(op_info_power);
    }
}