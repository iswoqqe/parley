package parley.systems;

import asciiPanel.AsciiPanel;
import parley.ecs.core.*;
import parley.events.GetPositionQuery;
import parley.events.GetTextureQuery;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class UI extends JFrame implements ISystem {
    public static final int width = 80;
    public static final int height = 43;
    private char[][] chars;
    private AsciiPanel terminal;

    private void clear() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                chars[i][j] = ' ';
            }
        }
    }

    public UI() {
        this.chars = new char[width][height];
        clear();

        this.terminal = new AsciiPanel(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(terminal);
        pack();
        setVisible(true);
    }

    private boolean canDraw(int x, int y) {
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    @Override
    public void run(IGameState entities) {
        clear();

        GetPositionQuery getPositionQuery = new GetPositionQuery();
        GetTextureQuery getTextureQuery = new GetTextureQuery();

        for (IEntity entity : entities.all()) {
            getPositionQuery.reset();
            getTextureQuery.reset();

            entity.fireEvent(getPositionQuery);
            entity.fireEvent(getTextureQuery);

            if (getPositionQuery.foundPosition() && getTextureQuery.foundTexture()) {
                int x = getPositionQuery.getX();
                int y = getPositionQuery.getY();
                char texture = getTextureQuery.getTexture();

                if (canDraw(x, y)) {
                    chars[x][y] = texture;
                }
            }
        }

        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < height; ++j) {
                    terminal.write(chars[i][j], i, j);
                }
            }

            terminal.repaint();
        });
    }
}
