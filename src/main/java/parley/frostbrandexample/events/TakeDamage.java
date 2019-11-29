package parley.frostbrandexample.events;

import parley.ecs.core.IEvent;
import parley.frostbrandexample.components.AttackModifier;
import parley.frostbrandexample.components.Health;

import java.util.List;

public class TakeDamage implements IEvent {
    private List<AttackModifier> modifiers;

    public TakeDamage(List<AttackModifier> modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public void visit(Health health) {
        for (AttackModifier modifier : modifiers) {
            health.takeDamage(modifier.getDamage());
        }
    }
}
