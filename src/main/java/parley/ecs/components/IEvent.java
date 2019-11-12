package parley.ecs.components;

import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;

public interface IEvent {
    default void visit(PhysicalObject physicalObject, IEntity self) {}
    default void visit(Player player, IEntity self) {}
    default void visit(AI ai, IEntity self) {}
}
