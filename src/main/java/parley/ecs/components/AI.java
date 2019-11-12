package parley.ecs.components;

import parley.ecs.core.IComponent;
import parley.ecs.core.IEntity;

public class AI implements IComponent {
    @Override
    public void accept(IEvent event, IEntity self) {
        event.visit(this, self);
    }
}
