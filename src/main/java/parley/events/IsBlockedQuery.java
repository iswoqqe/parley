package parley.events;

import parley.ecs.components.IEvent;
import parley.ecs.components.PhysicalObject;
import parley.ecs.core.IEntity;

public class IsBlockedQuery implements IEvent {
    private boolean blocked;
    private int x;
    private int y;

    public IsBlockedQuery(int x, int y) {
        this.x = x;
        this.y = y;
        this.blocked = false;
    }

    @Override
    public void visit(PhysicalObject physicalObject, IEntity self) {
        if (x == physicalObject.getX() && y == physicalObject.getY()) {
            blocked = true;
        }
    }

    public boolean result() {
        return blocked;
    }
}
