package parley.ecs.core;

import parley.ecs.components.Tag;

/**
 * @brief An collection of components and tags with an unique id.
 *        `IEvent`s should be used to interact with components.
 *        This is effectively a noun.
 */

public interface IEntity {
    void fireEvent(IEvent event);
    boolean hasTags(Tag... tag);
    void addTag(Tag tag);
    void removeTag(Tag tag);
    int getId();
}
