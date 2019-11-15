package parley.ecs.core;

import parley.ecs.components.Tag;

import java.util.Iterator;

/**
 * @brief interface for the entity storage in the engine.
 */

public interface IGameState {
    /**
     * @return an IEntity with the specified id if such an entity exists, otherwise null
     */
    IEntity entityWithId(int entityID);

    /**
     * @return an iterator iterating over each entity once
     */
    Iterable<IEntity> all();

    /**
     * @param tags the required tags of all returned entities
     * @return an iterator iterating over each entity with all specified tags once
     */
    Iterable<IEntity> allWithTags(Tag... tags);
}
