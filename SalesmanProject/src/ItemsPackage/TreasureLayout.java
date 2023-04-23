package ItemsPackage;

import javax.swing.*;

public class TreasureLayout extends ItemsLayout {
    int type;

    public TreasureLayout(JFrame frame, int type, int x, int y) {
        super(frame, "tre" + type, x, y);
        this.type = type;
    }
}
