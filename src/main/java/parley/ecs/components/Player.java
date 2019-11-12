package parley.ecs.components;

import parley.ecs.core.IComponent;
import parley.ecs.core.IEntity;

public class Player implements IComponent {
    public Player() {
    }

    @Override
    public void accept(IEvent event, IEntity self) {
        event.visit(this, self);
    }
}
