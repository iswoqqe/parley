package parley.ecs.core;

/**
 * @brief A system is a concrete subsystem of the game logic, such as a game mechanic.
 *
 */

public interface ISystem {
    /**
     * @brief This method is called by the engine to run systems.
     * @param entities the current game state.
     */
    void run(IGameState entities);
}
