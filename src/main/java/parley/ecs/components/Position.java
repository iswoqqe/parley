package parley.ecs.components;

import parley.ecs.core.Entity;
import parley.ecs.core.IComponent;
import parley.ecs.core.IEvent;
import parley.ecs.events.Move;

public class Position implements IComponent {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void runEvent(IEvent event, Entity self) {
        if (event instanceof Move) {
            Move move = (Move) event;

            this.x = move.getDestX();
            this.y = move.getDestY();
        }
    }
}
