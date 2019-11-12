package parley.ecs.core;

import parley.ecs.components.IComponentVisitor;

public interface IComponent {
    void accept(IComponentVisitor event);
}
