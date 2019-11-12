package parley.ecs.core;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public Iterable<IEntity> allWithComponents(Class<? extends IComponent>... componentTypes) {
        List<IEntity> ret = new ArrayList<>();

        for (IEntity entity : entities) {
            boolean addEntity = true;

            for (Class<? extends IComponent> type : Arrays.asList(componentTypes)) {
                if (!entity.hasComponent(type)) {
                    addEntity = false;
                    break;
                }
            }

            if (addEntity) {
                ret.add(entity);
            }
        }

        return ret;
    }
}
