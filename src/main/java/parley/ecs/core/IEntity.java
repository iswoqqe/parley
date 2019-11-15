package parley.ecs.core;

import parley.ecs.components.Tag;

public interface IEntity {
    void fireEvent(IEvent event);
    boolean hasTags(Tag... tag);
    void addTag(Tag tag);
    void removeTag(Tag tag);
    int getId();
}
