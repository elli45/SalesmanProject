package Player;

import javax.swing.*;
import java.util.Arrays;
import MapPackage.MapLayout;
import GamePackage.GameLayout;

public class Player {
    public int id = 0;
    public int power = 0;
    public double money = 0;
    public int current_x = 0;
    public int current_y = 0;
    public int[][] visited = new int[MapLayout.map_blocks_count][MapLayout.map_blocks_count];
    JFrame frame;
    JLabel player;

    public Player(JFrame frame, int id) {
        for (int[] row : visited)
            Arrays.fill(row, 0);

        this.id = id;
        this.current_x = 0;
        this.current_y = 0;
        this.frame = frame;

        JLabel item;

        if (id == 1) {
            item = new JLabel(new ImageIcon("Assets/player1.png"));
        } else {
            item = new JLabel(new ImageIcon("Assets/player2.png"));
        }

        item.setBounds(GameLayout.x_0, GameLayout.y_0, 50, 50);

        this.player = item;

        frame.add(item);
    }

    public void setMoney(double money) {
        this.money += money;
    }

    public void setPower(int power) {
        this.power += power;
    }

    public void checkVisited(int x, int y) {
        visited[x][y] = 1;
    }

    public void setCurrent_x(int current_x) {
        this.current_x = current_x;
    }

    public void setCurrent_y(int current_y) {
        this.current_y = current_y;
    }

    public void move(int x, int y) {
        frame.remove(player);

        if (this.id == 1) {
            player = new JLabel(new ImageIcon("Assets/player1.png"));
        } else {
            player = new JLabel(new ImageIcon("Assets/player2.png"));
        }

        player.setBounds(GameLayout.x_0 + (y * GameLayout.distance), GameLayout.y_0 + (x * GameLayout.distance), 50, 50);
        frame.add(player);
        frame.setVisible(true);
    }
}
