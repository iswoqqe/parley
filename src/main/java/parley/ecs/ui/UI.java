package parley.ecs.ui;

import parley.ecs.core.Engine;

public class UI {
    public static final int width = 80;
    public static final int height = 43;
    private static UIFrame uiFrame;

    public static void startService(Engine engine) {
        uiFrame = new UIFrame(width, height);

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
}
