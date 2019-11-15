package parley.ecs.components;

public interface IComponentVisitor {
    default void visit(PhysicalObject physicalObject) {}
    default void visit(Player player) {}
    default void visit(AI ai) {}
}
