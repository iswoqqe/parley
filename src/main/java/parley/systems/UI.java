package parley.systems;

import asciiPanel.AsciiPanel;
import parley.ecs.components.IEvent;
import parley.ecs.components.PhysicalObject;
import parley.ecs.core.*;

import javax.swing.*;

public class UI extends JFrame implements ISystem, IEvent {
    public static final int width = 80;
    public static final int height = 43;
    private AsciiPanel terminal;

    // Filled in when fired as an event
    private boolean gotPosition;
    private boolean gotTexture;
    private char texture;
    private int x;
    private int y;

    public static void start(Engine engine) {
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

    private boolean canDraw() {
        return gotPosition && gotTexture
                && 0 < x && x < width
                && 0 <= y && y < height;
    }

    @Override
    public void run(IGameState entities) {
        terminal.clear();

        for (IEntity entity : entities.all()) {
            gotPosition = false;
            gotTexture = false;

            entity.fireEvent(this);

            if (canDraw()) {
                terminal.write(texture, x, y);
            }
        }

        terminal.repaint();
    }

    @Override
    public void visit(PhysicalObject physicalObject, IEntity self) {
        this.x = physicalObject.getX();
        this.y = physicalObject.getY();
        this.texture = physicalObject.getTexture();
        this.gotPosition = true;
        this.gotTexture = true;
    }
}
