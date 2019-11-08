package parley;

import asciiPanel.AsciiPanel;
import parley.ecs.components.Position;
import parley.ecs.components.Texture;
import parley.ecs.core.Entity;
import parley.ecs.core.GameState;

import javax.swing.*;

public class UI extends JFrame {
    private AsciiPanel terminal;

    static private boolean canDrawPredicate(Entity entity) {
        if (!entity.hasComponent(Position.class) || !entity.hasComponent(Texture.class)) {
            return false;
        }

        Position position = entity.getComponent(Position.class);

        if (80 <= position.getX() || position.getX() < 0) {
            return false;
        }

        if (40 <= position.getY() || position.getY() < 0) {
            return false;
        }

        return true;
    }

    public void update(GameState state) {
        terminal.clear();

        for (Entity drawable : state.allSatisfying(UI::canDrawPredicate)) {
            Position position = drawable.getComponent(Position.class);
            Texture texture = drawable.getComponent(Texture.class);

            terminal.write(texture.getSymbol(), position.getX(), position.getY());
        }

        terminal.repaint();
    }

    public UI() {
        terminal = new AsciiPanel(80, 40);
        add(terminal);
        pack();
        setVisible(true);
    }
}
