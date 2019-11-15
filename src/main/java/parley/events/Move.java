package parley.events;

import parley.ecs.components.PhysicalObject;
import parley.ecs.core.IEvent;
import parley.systems.UI;

public class Move implements IEvent {
    private int destX;
    private int destY;

    public Move(int destX, int destY) {
        this.destX = Math.floorMod(destX, UI.width);
        this.destY = Math.floorMod(destY, UI.height);
    }

    @Override
    public void visit(PhysicalObject physicalObject) {
        physicalObject.setX(destX);
        physicalObject.setY(destY);
    }
}
