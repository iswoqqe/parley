package parley.ecs.core;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class GameState {
    private List<Entity> entities;

    public GameState(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Entity> all() {
        return new ArrayList<Entity>(entities);
    }

    public List<Entity> allSatisfying(Function<Entity, Boolean>... predicates) {
        List<Entity> ret = new ArrayList<>();

        for (Entity entity : entities) {
            boolean satisfied = true;

            for (Function<Entity, Boolean> function : predicates) {
                if (!function.apply(entity)) {
                    satisfied = false;
                    break;
                }
            }

            if (satisfied) {
                ret.add(entity);
            }
        }

        return ret;
    }

    public List<Entity> allWithComponents(Class<? extends IComponent>... types) {
        Function<Entity, Boolean>[] predicates = new Function[types.length];

        for (int i = 0; i < types.length; ++i) {
            Class<? extends IComponent> type = types[i];
            predicates[i] = ((Entity entity) -> entity.hasComponent(type));
        }

        return allSatisfying(predicates);
    }
}
