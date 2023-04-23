package GamePackage;

import javax.swing.*;
import ColorPackage.ProjectColors;
import ControllerPackage.ControllerLayout;
import MapPackage.MapLayout;
import DicePackage.DiceLayout;
import ScoreBoardPackage.ScoreBoardLayout;
import Player.Player;

public class GameLayout {
    public static int frame_width = 1000;
    public static int frame_height = 700;

    public static int x_0 = 35;
    public static int y_0 = 35;
    public static int distance = 60;

    public static int turn = 1;

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame1 = new JFrame("Traveling Salesman");
        frame1.setSize(frame_width, frame_height);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(ProjectColors.backgroundColor);

        MapLayout map1 = new MapLayout();
        ControllerLayout controller1 = new ControllerLayout(frame1);
        DiceLayout dice1 = new DiceLayout(frame1);
        new ScoreBoardLayout(frame1);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame2 = new JFrame("Traveling Salesman");
        frame2.setSize(frame_width, frame_height);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().setBackground(ProjectColors.backgroundColor);

        MapLayout map2 = new MapLayout();
        ControllerLayout controller2 = new ControllerLayout(frame2);
        DiceLayout dice2 = new DiceLayout(frame2);
        new ScoreBoardLayout(frame2);

        Player p1 = new Player(frame1, 1);
        Player p2 = new Player(frame2, 2);

        frame1.add(map1);
        frame1.setVisible(true);

        frame2.add(map2);
        frame2.setVisible(true);

        int dice_value;
        int direction;
        int next_x, next_y;

        while (true) {
            if (turn == 1) {
                dice_value = dice1.dice_value;
                System.out.println(dice_value);
                if (!dice1.dice_played) {
                    if (!controller1.direction_played) {
                        direction = controller1.direction;
                        if (direction == 1) { // Right
                            next_x = p1.current_x + dice_value;
                            next_y = p1.current_y;
                        } else if (direction == 2) { // Bottom
                            next_x = p1.current_x;
                            next_y = p1.current_y + dice_value;
                        } else if (direction == 3) { // Left
                            next_x = p1.current_x - dice_value;
                            next_y = p1.current_y;
                        } else { // Top
                            next_x = p1.current_x;
                            next_y = p1.current_y - dice_value;
                        }

                        if (next_x >= 0 && next_x < 10 && next_y >= 0 && next_y < 10) {
                            if (p1.visited[next_x][next_y] == 0) {
                                p1.move(1, 1);
                                dice1.setDice_played(true);
                                controller1.setDirection_played(true);
                                p1.setCurrent_x(next_x);
                                p1.setCurrent_y(next_y);
                                if (p1.current_x == p2.current_x && p1.current_y == p2.current_y) {
                                    fight(p1, p2, 1);
                                }
                                turn = 2;
                            } else {
                                turn = 2;
                            }
                        }

                    }

                }
            } else {
                dice_value = dice2.dice_value;
                System.out.println(dice_value);
                if (!dice2.dice_played) {
                    if (!controller2.direction_played) {
                        direction = controller2.direction;
                        if (direction == 1) { // Right
                            next_x = p2.current_x + dice_value;
                            next_y = p2.current_y;
                        } else if (direction == 2) { // Bottom
                            next_x = p2.current_x;
                            next_y = p2.current_y + dice_value;
                        } else if (direction == 3) { // Left
                            next_x = p2.current_x - dice_value;
                            next_y = p2.current_y;
                        } else { // Top
                            next_x = p2.current_x;
                            next_y = p2.current_y - dice_value;
                        }

                        if (next_x >= 0 && next_x < 10 && next_y >= 0 && next_y < 10) {
                            if (p2.visited[next_x][next_y] == 0) {
                                p2.move(1, 1);
                                dice2.setDice_played(true);
                                controller2.setDirection_played(true);
                                p2.setCurrent_x(next_x);
                                p2.setCurrent_y(next_y);
                                if (p1.current_x == p2.current_x && p1.current_y == p2.current_y) {
                                    fight(p1, p2, 2);
                                }
                                turn = 2;
                            } else {
                                turn = 2;
                            }
                        }

                    }

                }
            }
        }

    }

    static void fight(Player p1, Player p2, int arrived) {
        int winner = 0;
        if (p1.power > p2.power) {
            winner = 1;
        } else if (p1.power < p2.power) {
            winner = 2;
        } else if (p1.power == p2.power) {
            if (arrived == 1) {
                winner = 2;
            } else if (arrived == 2) {
                winner = 1;
            }
        }

        if (winner == 1) {
            System.out.println("P1 Wins");
            double add = ((p1.power - p2.power) / (p1.power + p2.power)) * p2.money;
            p1.power -= p2.power;
            p2.power = 0;
            p1.money += add;
            p2.money -= add;
        } else {
            System.out.println("P2 Wins");
            double add = ((p2.power - p1.power) / (p2.power + p1.power)) * p1.money;
            p2.power -= p1.power;
            p1.power = 0;
            p2.money += add;
            p1.money -= add;
        }
    }
}