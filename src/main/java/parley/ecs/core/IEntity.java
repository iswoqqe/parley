package parley.ecs.core;

import parley.ecs.components.IEvent;

public interface IEntity {
    void fireEvent(IEvent event);
    boolean hasComponent(Class<? extends IComponent> type);
    <T extends IComponent> T getComponent(Class<T> type);
}
