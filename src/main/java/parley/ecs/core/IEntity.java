package parley.ecs.core;

public interface IEntity {
    void fireEvent(IEvent event);
    boolean hasComponent(Class<? extends IComponent> type);
}
