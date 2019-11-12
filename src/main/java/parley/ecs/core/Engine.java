package parley.ecs.core;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private GameState state;

    public Engine() {
        this.state = new GameState();
    }

    /**
     * @brief Run a system on the current game state.
     * @param system the system to run
     */
    public void runSystem(ISystem system) {
        system.run(state);
    }

    /**
     * @brief Return a nice interface for creating and inserting entities into the game state.
     * @return a new Engine.EntityBuilder instance connected to this engine instance
     */
    public EntityBuilder newEntity() {
        return new EntityBuilder(state);
    }

    /**
     * @brief A nice interface for creating and inserting entities into the game state.
     */
    public static class EntityBuilder {
        private boolean done;
        private List<IComponent> components;
        private GameState state;

        EntityBuilder(GameState state) {
            this.done = false;
            this.state = state;
            this.components = new ArrayList<>();
        }

        public EntityBuilder with(IComponent component) {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            components.add(component);
            return this;
        }

        public void build() {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            state.add(new Entity(components));

            state = null;
            components = null;
            done = true;
        }
    }
}
