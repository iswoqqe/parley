package parley.ecs.core;

public interface IComponent {
    void runEvent(IEvent event, Entity self);
}
