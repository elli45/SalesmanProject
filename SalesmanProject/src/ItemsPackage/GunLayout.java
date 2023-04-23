package ItemsPackage;

import javax.swing.*;

public class GunLayout extends ItemsLayout {
    int type;

    public GunLayout(JFrame frame, int type, int x, int y) {
        super(frame, "gun" + type, x, y);
        this.type = type;
    }
}
