package ItemsPackage;

import javax.swing.*;

public class ItemsLayout {

    public ItemsLayout (JFrame frame, String name, int x, int y) {

        JLabel item = new JLabel(new ImageIcon("Assets/items/"+name+".png"));
        item.setBounds(x, y, 50, 50);
        
        frame.add(item);
    }
}