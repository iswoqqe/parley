package parley.ecs.core;

public interface IEntity {
    <T> T fireEvent(IEvent<T> event);
    boolean hasComponent(Class<? extends IComponent> type);
}
