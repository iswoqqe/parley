package parley.ecs.core;

/**
 * @brief A system processes the current game state.
 */

public interface ISystem {
    /**
     * @brief This method is called by the engine to run systems.
     * @param entities the current game state.
     */
    void run(IGameState entities);
}
