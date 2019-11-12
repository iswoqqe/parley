package parley.ecs.core;

import java.util.List;

/**
 * @brief very simple implementation of IEntity
 */

public class Entity implements IEntity {
    private List<IComponent> components;

    Entity(List<IComponent> components) {
        this.components = components;
    }

    @Override
    public <T> T fireEvent(IEvent<T> event) {
        for (IComponent component : components) {
            component.accept(event);
        }

        return event.getValue();
    }

    @Override
    public boolean hasComponent(Class<? extends IComponent> type) {
        for (IComponent component : components) {
            if (component.getClass().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
