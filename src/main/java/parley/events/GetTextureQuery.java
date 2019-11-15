package parley.events;

import parley.ecs.components.PhysicalObject;
import parley.ecs.core.IEvent;

public class GetTextureQuery implements IEvent {
    private boolean found;
    private char texture;

    public GetTextureQuery() {
        this.found = false;
    }

    @Override
    public void visit(PhysicalObject physicalObject) {
        found = true;
        texture = physicalObject.getTexture();
    }

    public void reset() {
        found = false;
    }

    public boolean foundTexture() {
        return found;
    }

    public char getTexture() {
        return texture;
    }
}
