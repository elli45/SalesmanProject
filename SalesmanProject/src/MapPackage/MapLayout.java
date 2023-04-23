package MapPackage;

import java.awt.*;
import javax.swing.*;

import ColorPackage.ProjectColors;

public class MapLayout extends JComponent {
    public static int map_blocks_count = 10;

    public static int map_size = 600;
    public static int block_size = map_size / map_blocks_count;

    int start_x = 30;
    int start_y = 30;

    public void paint(Graphics g) {
        g.setColor(ProjectColors.mapBorderColor);
        g.drawRect(start_x, start_y, map_size, map_size);

        for (int row = 1; row < map_blocks_count; row++) {
            int current_x = start_x;
            int current_y = start_y + (row * block_size);
            g.drawLine(current_x, current_y, current_x + map_size, current_y);
        }

        for (int col = 1; col < map_blocks_count; col++) {
            int current_x = start_x + (col * block_size);
            int current_y = start_y;
            g.drawLine(current_x, current_y, current_x, current_y + map_size);
        }
    }
}
