package parley.ecs.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief very simple implementation of IGameState
 */

class GameState implements IGameState {
    private List<IEntity> entities;

    GameState() {
        this.entities = new ArrayList<>();
    }

    void add(IEntity entity) {
        entities.add(entity);
    }

    @Override
    public List<IEntity> all() {
        return entities;
    }
}
