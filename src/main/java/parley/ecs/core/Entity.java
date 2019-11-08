package parley.ecs.core;

import java.util.List;

public class Entity {
    private List<IComponent> components;

    public Entity(List<IComponent> components) {
        this.components = components;
    }

    public boolean hasComponent(Class<? extends IComponent> type) {
        for (IComponent component : components) {
            if (component.getClass().equals(type)) {
                return true;
            }
        }

        return false;
    }

    public <T extends IComponent> T getComponent(Class<T> type) {
        for (IComponent component : components) {
            if (component.getClass().equals(type)) {
                return (T) component;
            }
        }

        return null;
    }

    public void runEvent(IEvent event) {
        for (IComponent component : components) {
            component.runEvent(event, this);
        }
    }
}
