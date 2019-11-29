package parley.frostbrandexample.events;

import parley.ecs.core.IEntity;
import parley.ecs.core.IEvent;
import parley.frostbrandexample.components.AttackModifier;

import java.util.ArrayList;
import java.util.List;

public class PerformAttack implements IEvent {
    private List<AttackModifier> modifiers;
    private IEntity target;

    public PerformAttack(IEntity target) {
        this.modifiers = new ArrayList<>();
        this.target = target;
    }

    @Override
    public void visit(AttackModifier attackModifier) {
        modifiers.add(attackModifier);
    }

    @Override
    public void postHook() {
        target.fireEvent(new TakeDamage(modifiers));
    }
}
