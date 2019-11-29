package parley.ecs.core;

import parley.ecs.components.IComponentVisitor;

/**
 * @brief An event is a signal to an entity to perform an action.
 *        An action does not necessarily change the game state.
 *        This is effectively a verb.
 */

public interface IEvent extends IComponentVisitor {
    /**
     * @brief will be ran before visiting any components.
     */
    default void preHook() {}

    /**
     * @brief will be ran after visiting any components.
     */
    default void postHook() {}
}
