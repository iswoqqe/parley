package parley.ecs.core;

import java.util.Iterator;
import java.util.List;

/**
 * @brief very simple implementation of IGameState
 */

class GameState implements IGameState {
    private List<IEntity> entities;

    GameState() {
    }

    void add(IEntity entity) {
        entities.add(entity);
    }

    @Override
    public Iterator<IEntity> all() {
        return entities.iterator();
    }
}
