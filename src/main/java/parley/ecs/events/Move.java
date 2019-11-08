package parley.ecs.events;

import parley.ecs.core.IEvent;

public class Move implements IEvent {
    private int destX;
    private int destY;

    public Move(int destX, int destY) {
        this.destX = destX;
        this.destY = destY;
    }

    public int getDestX() {
        return destX;
    }

    public int getDestY() {
        return destY;
    }
}
