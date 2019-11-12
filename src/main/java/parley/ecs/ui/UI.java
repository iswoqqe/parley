package parley.ecs.ui;

import parley.ecs.core.Engine;

public class UI {
    public static final int width = 80;
    public static final int height = 43;
    private static UIFrame uiFrame;
    private static DrawSystem system;

    public static void startService(Engine engine) {
        uiFrame = new UIFrame(width, height);
        system = new DrawSystem(uiFrame);

        new Thread(() -> {
            while (true) {
                try {
                    engine.runSystem(system);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("Closing down UI because of exception:\n" + e.getMessage());
                    return;
                }
            }
        }).start();
    }
}
