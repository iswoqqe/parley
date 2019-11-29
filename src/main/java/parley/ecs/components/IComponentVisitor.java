package parley.ecs.components;

import parley.frostbrandexample.components.AttackModifier;
import parley.frostbrandexample.components.Health;

public interface IComponentVisitor {
    default void visit(PhysicalObject physicalObject) {}
    default void visit(AttackModifier attackModifier) {}
    default void visit(Health health) {}
}
