package parley.systems;

import asciiPanel.AsciiPanel;
import parley.ecs.components.PhysicalObject;
import parley.ecs.core.*;

import javax.swing.*;

public class UI extends JFrame implements ISystem {
    public static final int width = 80;
    public static final int height = 43;
    private AsciiPanel terminal;

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

    private boolean canDraw(PhysicalObject object) {
        return 0 < object.getX() && object.getX() < width
                && 0 <= object.getY() && object.getY() < height;
    }

    @Override
    public void run(IGameState entities) {
        terminal.clear();

        for (IEntity entity : entities.allWithComponents(PhysicalObject.class)) {
            PhysicalObject object = entity.getComponent(PhysicalObject.class);

            if (canDraw(object)) {
                terminal.write(object.getTexture(), object.getX(), object.getY());
            }
        }

        terminal.repaint();
    }
}
