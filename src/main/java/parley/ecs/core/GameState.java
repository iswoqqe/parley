package parley.ecs.core;

import parley.ecs.components.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @brief very simple implementation of IGameState
 */

class GameState implements IGameState {
    private Map<Integer, IEntity> entities;

    GameState() {
        this.entities = new HashMap<>();
    }

    void add(IEntity entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public IEntity entityWithId(int entityID) {
        return entities.get(entityID);
    }

    @Override
    public Iterable<IEntity> all() {
        return entities.values();
    }

    @Override
    public Iterable<IEntity> allWithTags(Tag... tags) {
        List<IEntity> ret = new ArrayList<>();

        for (IEntity entity : entities.values()) {
            if (entity.hasTags(tags)) {
                ret.add(entity);
            }
        }

        return ret;
    }
}
