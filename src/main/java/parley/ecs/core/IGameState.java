package parley.ecs.core;

import java.util.Iterator;

/**
 * @brief interface for the entity storage in the engine.
 */

public interface IGameState {
    /**
     * @return an iterator iterating over each entity once
     */
    Iterable<IEntity> all();

    Iterable<IEntity> allWithComponents(Class<? extends IComponent>... componentTypes);
}
