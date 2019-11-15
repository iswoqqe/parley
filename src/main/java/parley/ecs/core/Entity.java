package parley.ecs.core;

import parley.ecs.components.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @brief very simple implementation of IEntity
 */

public class Entity implements IEntity {
    private int id;
    private List<IComponent> components;
    private Set<Tag> tags;

    public Entity(int id, List<IComponent> components, Set<Tag> tags) {
        this.id = id;
        this.tags = tags;
        this.components = components;
    }

    @Override
    public void fireEvent(IEvent event) {
        for (IComponent component : components) {
            component.accept(event);
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean hasTags(Tag... tags) {
        for (Tag tag : tags) {
            if (!this.tags.contains(tag)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void addTag(Tag tag) {
        tags.add(tag);
    }

    @Override
    public void removeTag(Tag tag) {
        tags.remove(tag);
    }
}
