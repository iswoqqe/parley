package parley.ecs.components;

public interface IComponentVisitor {
    default void visit(PhysicalObject physicalObject) {}
}
