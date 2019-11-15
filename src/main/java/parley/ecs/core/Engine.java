package parley.ecs.core;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private GameState state;
    private int nextEntityId;

    public Engine() {
        this.state = new GameState();
        this.nextEntityId = 0;
    }

    /**
     * @brief Run a system on the current game state.
     * @param system the system to run
     */
    public void runSystem(ISystem system) {
        synchronized (state) {
            system.run(state);
        }
    }

    /**
     * @brief Return a nice interface for creating and inserting entities into the game state.
     * @return a new Engine.EntityBuilder instance connected to this engine instance
     */
    public EntityBuilder newEntity() {
        return new EntityBuilder();
    }

    /**
     * @brief A nice interface for creating and inserting entities into the game state.
     */
    public class EntityBuilder {
        private boolean done;
        private List<IComponent> components;

        EntityBuilder() {
            this.done = false;
            this.components = new ArrayList<>();
        }

        public EntityBuilder with(IComponent component) {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            components.add(component);
            return this;
        }

        public int build() {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            int ret;

            synchronized (state) {
                state.add(new Entity(nextEntityId, components));
                ret = nextEntityId;
                nextEntityId += 1;
            }

            components = null;
            done = true;

            return ret;
        }
    }
}
