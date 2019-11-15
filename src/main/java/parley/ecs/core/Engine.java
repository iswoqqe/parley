package parley.ecs.core;

import parley.ecs.components.Tag;

import java.util.*;

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

    public boolean hasTags(int entityId, Tag... tags) {
        synchronized (state) {
            IEntity entity = state.entityWithId(entityId);
            return entity != null && entity.hasTags(tags);
        }
    }

    public void addTag(int entityId, Tag tag) {
        synchronized (state) {
            IEntity entity = state.entityWithId(entityId);
            if (entity != null) {
                entity.addTag(tag);
            }
        }
    }

    public void removeTag(int entityId, Tag tag) {
        synchronized (state) {
            IEntity entity = state.entityWithId(entityId);
            if (entity != null) {
                entity.removeTag(tag);
            }
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
        private Set<Tag> tags;
        private List<IComponent> components;

        EntityBuilder() {
            this.done = false;
            this.tags = EnumSet.noneOf(Tag.class);
            this.components = new ArrayList<>();
        }

        public EntityBuilder withComponent(IComponent component) {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            components.add(component);
            return this;
        }

        public EntityBuilder withTag(Tag tag) {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            tags.add(tag);
            return this;
        }


        public int build() {
            if (done) {
                throw new UnsupportedOperationException("build() has already been called in Engine.EntityBuilder");
            }

            int ret;

            synchronized (state) {
                state.add(new Entity(nextEntityId, components, tags));
                ret = nextEntityId;
                nextEntityId += 1;
            }

            components = null;
            done = true;

            return ret;
        }
    }
}
