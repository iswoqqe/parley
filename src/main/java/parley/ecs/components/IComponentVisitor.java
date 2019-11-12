package parley.ecs.components;

public interface IComponentVisitor {
    default void visit(Position position) {}
    default void visit(Solid solid) {}
    default void visit(Texture texture) {}
}
