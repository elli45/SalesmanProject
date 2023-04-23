package ItemsPackage;

import MapPackage.MapLayout;
import Player.Player;

import javax.swing.*;
import java.util.Random;

public class MarketLayout extends ItemsLayout {

    public MarketLayout(JFrame frame, int x, int y) {
        super(frame, "market", x, y);
    }

    public void buyGun(int x, int y, int typeGun, Player player) {
        GunLayout gunLayout = null;
        if (typeGun == 1 && player.money >= 100) {
            player.money -= 100;
            gunLayout = new GunLayout(player.frame, 1, x, y);
        } else if (typeGun == 2 && player.money >= 200) {
            player.money -= 200;
            gunLayout = new GunLayout(player.frame, 2, x, y);
        } else if (typeGun == 3 && player.money >= 500) {
            player.money -= 500;
            gunLayout = new GunLayout(player.frame, 3, x, y);
        } else {
            System.out.println("Money isn't enough or type gun is incorrect");
            return;
        }
        player.guns.add(gunLayout);
    }

    public TreasureLayout getPositionTreasure(Player player, MapLayout mapLayout) {
        if (player.money >= 200) {
            Random rand = new Random();
            TreasureLayout treasureLayout;
            while (true) {
                treasureLayout = mapLayout.treasures.get(rand.nextInt(mapLayout.treasures.size()));
                if (!player.foundTreasures.contains(treasureLayout))
                    break;
            }
            player.foundTreasures.add(treasureLayout);
            player.money -= 200;
            return treasureLayout;
        } else {
            System.out.println("Money isn't enough!!!");
            return null;
        }
    }
}
