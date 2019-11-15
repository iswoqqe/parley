package parley.ecs.core;

import java.util.List;

/**
 * @brief very simple implementation of IEntity
 */

public class Entity implements IEntity {
    private int id;
    private List<IComponent> components;

    public Entity(int id, List<IComponent> components) {
        this.id = id;
        this.components = components;
    }

    @Override
    public void fireEvent(IEvent event) {
        for (IComponent component : components) {
            component.accept(event);
        }
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

    @Override
    public <T extends IComponent> T getComponent(Class<T> type) {
        for (IComponent component : components) {
            if (component.getClass().equals(type)) {
                return (T) component;
            }
        }

        return null;
    }

    @Override
    public int getId() {
        return id;
    }
}
