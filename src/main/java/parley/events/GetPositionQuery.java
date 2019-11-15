package parley.events;

import parley.ecs.components.PhysicalObject;
import parley.ecs.core.IEntity;
import parley.ecs.core.IEvent;

public class GetPositionQuery implements IEvent {
    private boolean found;
    private int x;
    private int y;

    public GetPositionQuery() {
        this.found = false;
    }

    @Override
    public void visit(PhysicalObject physicalObject) {
        found = true;
        x = physicalObject.getX();
        y = physicalObject.getY();
    }

    public boolean foundPosition() {
        return found;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
