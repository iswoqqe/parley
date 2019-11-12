package parley.ecs.ui;

import asciiPanel.AsciiPanel;
import parley.ecs.components.Position;
import parley.ecs.components.Texture;
import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;
import parley.ecs.core.ISystem;

import javax.swing.*;

class UIFrame extends JFrame implements ISystem {
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

    boolean canDraw(DrawInfo.Return info) {
        return 0 <= info.getX() && info.getX() < width && 0 <= info.getY() && info.getY() < height;
    }

    @Override
    public void run(IGameState entities) {
        terminal.clear();

        for (IEntity entity : entities.allWithComponents(Position.class, Texture.class)) {
            DrawInfo.Return info = entity.fireEvent(new DrawInfo());

            if (canDraw(info)) {
                terminal.write(info.getTexture(), info.getX(), info.getY());
            }
        }

        terminal.repaint();
    }
}
