package parley.ecs.core;

import parley.ecs.components.IComponentVisitor;

public interface IEvent<T> extends IComponentVisitor {
    T getValue();
}
