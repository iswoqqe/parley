package parley.frostbrandexample.components;

import parley.ecs.components.IComponentVisitor;
import parley.ecs.core.IComponent;

public class AttackModifier implements IComponent {
    private int damage;
    private Type type;

    public AttackModifier(int damage, Type type) {
        this.damage = damage;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void accept(IComponentVisitor event) {
        event.visit(this);
    }

    public enum Type {
        Fire, Ice, Slashing, Piercing, Bludgeoning
    }
}
