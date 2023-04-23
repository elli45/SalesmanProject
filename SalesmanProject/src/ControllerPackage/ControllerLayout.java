package ControllerPackage;
import javax.swing.*;

public class ControllerLayout extends JComponent {
    public static int size1 = 65;
    public static int size2 = 80;

    public static int distance = size2;

    int start_x = 700;
    int start_y = 420;

    public ControllerLayout(JFrame frame) {
        ImageIcon topIcon = new ImageIcon("Assets/top-arrow.png");
        ImageIcon leftIcon = new ImageIcon("Assets/left-arrow.png");
        ImageIcon rightIcon = new ImageIcon("Assets/right-arrow.png");
        ImageIcon bottomIcon = new ImageIcon("Assets/bottom-arrow.png");

        int current_x = start_x + (2 * (size1) + distance - size2) / 2;
        int current_y = start_y;

        JButton topButton = new JButton(topIcon);
        topButton.setBounds(current_x, current_y, size2, size1);

        current_x = start_x;
        current_y += size1;

        JButton leftButton = new JButton(leftIcon);
        leftButton.setBounds(current_x, current_y, size1, size2);

        current_x += size1 + distance;

        JButton rightButton = new JButton(rightIcon);
        rightButton.setBounds(current_x, current_y, size1, size2);

        current_x = start_x + (2 * (size1) + distance - size2) / 2;
        current_y += size2;

        JButton bottomButton = new JButton(bottomIcon);
        bottomButton.setBounds(current_x, current_y, size2, size1);

        frame.add(topButton);
        frame.add(rightButton);
        frame.add(bottomButton);
        frame.add(leftButton);
    }
}
