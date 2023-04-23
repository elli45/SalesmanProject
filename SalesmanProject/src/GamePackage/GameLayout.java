package GamePackage;

import javax.swing.*;
import ColorPackage.ProjectColors;
import ControllerPackage.ControllerLayout;
import MapPackage.MapLayout;
import DicePackage.DiceLayout;
import ScoreBoardPackage.ScoreBoardLayout;
import ItemsPackage.ItemsLayout;

public class GameLayout {
    public static int frame_width = 1000;
    public static int frame_height = 700;

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Traveling Salesman");
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(ProjectColors.backgroundColor);

        MapLayout map = new MapLayout();
        new ControllerLayout(frame);
        new DiceLayout(frame);
        new ScoreBoardLayout(frame);

        int distance = 60;
        
        int c_x = 35, c_y = 35;
        new ItemsLayout(frame, "castle", c_x, c_y);
        new ItemsLayout(frame, "wall", c_x, c_y+=distance);
        new ItemsLayout(frame, "market", c_x, c_y+=distance);
        new ItemsLayout(frame, "loot", c_x, c_y+=distance);
        
        c_x+=distance;
        c_y = 35;
        new ItemsLayout(frame, "gun1", c_x, c_y);
        new ItemsLayout(frame, "gun2", c_x, c_y+=distance);
        new ItemsLayout(frame, "gun3", c_x, c_y+=distance);
        
        c_x+=distance;
        c_y = 35;
        new ItemsLayout(frame, "tre1", c_x, c_y);
        new ItemsLayout(frame, "tre2", c_x, c_y+=distance);
        new ItemsLayout(frame, "tre3", c_x, c_y+=distance);
        new ItemsLayout(frame, "tre4", c_x, c_y+=distance);
        new ItemsLayout(frame, "tre5", c_x, c_y+=distance);
        new ItemsLayout(frame, "tre6", c_x, c_y+=distance);
        new ItemsLayout(frame, "tre7", c_x, c_y+=distance);
        new ItemsLayout(frame, "tre8", c_x, c_y+=distance);

        frame.add(map);
        frame.setVisible(true);
    }
}