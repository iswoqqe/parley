package parley.ecs.ui;

import asciiPanel.AsciiPanel;

import javax.swing.*;

class UIFrame extends JFrame {
    private int width;
    private int height;
    private AsciiPanel terminal;

    UIFrame(int width, int height) {
        this.width = width;
        this.height = height;

        terminal = new AsciiPanel(width, height);
        add(terminal);
        pack();
        setVisible(true);
    }

    boolean canDraw(DrawInfoEvent info) {
        return 0 <= info.getX() && info.getX() < width && 0 <= info.getY() && info.getY() < height;
    }

    void draw(DrawInfoEvent info) {
        if (canDraw(info)) {
            terminal.write(info.getTexture(), info.getX(), info.getY());
        }
    }

    void preUpdates() {
        terminal.clear();
    }

    void postUpdates() {
        terminal.repaint();
    }
}
