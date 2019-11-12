package parley;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Inputs {
    private static int lastCode = KeyEvent.KEY_LOCATION_UNKNOWN;

    public static void startService() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new Dispatcher());
    }

    public static int lastKeyCode() {
        synchronized (Inputs.class) {
            int ret = lastCode;
            lastCode = KeyEvent.KEY_LOCATION_UNKNOWN;
            return ret;
        }
    }

    private static class Dispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            synchronized (Inputs.class) {
                if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
                    lastCode = keyEvent.getKeyCode();
                }
                return false;
            }
        }
    }
}
