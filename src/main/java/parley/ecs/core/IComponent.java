package parley.ecs.core;

import parley.ecs.components.IEvent;

public interface IComponent {
    void accept(IEvent event, IEntity self);
}
