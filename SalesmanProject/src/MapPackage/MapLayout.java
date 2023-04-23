package MapPackage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

import ColorPackage.ProjectColors;
import ItemsPackage.*;
import Player.Player;

public class MapLayout extends JComponent {
    public static int map_blocks_count = 10;

    public static int map_size = 600;
    public static int block_size = map_size / map_blocks_count;

    int start_x = 30;
    int start_y = 30;

    public ArrayList<TreasureLayout> treasures = new ArrayList<>();
    public CastleLayout castle;
    public ArrayList<LootLayout> loots = new ArrayList<>();
    public ArrayList<WallLayout> walls = new ArrayList<>();
    public ArrayList<MarketLayout> markets = new ArrayList<>();
    public ArrayList<TrapLayout> traps = new ArrayList<>();
    private int[][] mapValue = new int[map_blocks_count][map_blocks_count];

    public Player player;

    public MapLayout(JFrame frame) {
        Random rand = new Random();
        castle = new CastleLayout(frame, 5, 5);
        mapValue[5][5] = 1;
        for (int i = 1; i <= 8; i++) {
            int x = rand.nextInt(map_blocks_count), y = rand.nextInt(map_blocks_count);
            if (mapValue[x][y] != 0) {
                i--;
                continue;
            }
            mapValue[x][y] = 1;
            treasures.add(new TreasureLayout(frame, 1, x, y));
        }
        for (int i = 1; i <= 4; i++) {
            int x = rand.nextInt(map_blocks_count), y = rand.nextInt(map_blocks_count);
            if (mapValue[x][y] != 0) {
                i--;
                continue;
            }
            mapValue[x][y] = 1;
            markets.add(new MarketLayout(frame, x, y));
        }
        for (int i = 1; i <= 5; i++) {
            int x = rand.nextInt(map_blocks_count), y = rand.nextInt(map_blocks_count);
            if (mapValue[x][y] != 0) {
                i--;
                continue;
            }
            mapValue[x][y] = 1;
            walls.add(new WallLayout(frame, x, y));
        }
        for (int i = 1; i <= 13; i++) {
            int x = rand.nextInt(map_blocks_count), y = rand.nextInt(map_blocks_count);
            if (mapValue[x][y] != 0) {
                i--;
                continue;
            }
            mapValue[x][y] = 1;
            loots.add(new LootLayout(frame, x, y));
        }
        for (int i = 1; i <= rand.nextInt(5); i++) {
            int x = rand.nextInt(map_blocks_count), y = rand.nextInt(map_blocks_count);
            if (mapValue[x][y] != 0) {
                i--;
                continue;
            }
            mapValue[x][y] = 1;
            traps.add(new TrapLayout(frame, x, y));
        }

    }

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
