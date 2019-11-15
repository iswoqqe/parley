package parley;

import asciiPanel.AsciiPanel;
import parley.ecs.core.*;
import parley.events.GetPositionQuery;
import parley.events.GetTextureQuery;

import javax.swing.*;

public class UI extends JFrame implements ISystem {
    public static final int width = 80;
    public static final int height = 43;
    private AsciiPanel terminal;

    static void start(Engine engine) {
        UI uiFrame = new UI();

        new Thread(() -> {
            while (true) {
                try {
                    engine.runSystem(uiFrame);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Closing down UI because of exception:\n" + e.getMessage());
                    return;
                }
            }
        }).start();
    }

    private UI() {
        terminal = new AsciiPanel(width, height);
        add(terminal);
        pack();
        setVisible(true);
    }

    private boolean canDraw(int x, int y) {
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    @Override
    public void run(IGameState entities) {
        terminal.clear();

        for (IEntity entity : entities.all()) {
            GetPositionQuery getPositionQuery = new GetPositionQuery();
            GetTextureQuery getTextureQuery = new GetTextureQuery();

            entity.fireEvent(getPositionQuery);
            entity.fireEvent(getTextureQuery);

            if (getPositionQuery.foundPosition() && getTextureQuery.foundTexture()) {
                int x = getPositionQuery.getX();
                int y = getPositionQuery.getY();
                char texture = getTextureQuery.getTexture();

                if (canDraw(x, y)) {
                    terminal.write(texture, x, y);
                }
            }
        }

        terminal.repaint();
    }
}
