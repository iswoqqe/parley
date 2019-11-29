package parley.frostbrandexample.events;

import parley.ecs.core.IEvent;
import parley.frostbrandexample.components.AttackModifier;

import java.util.ArrayList;
import java.util.List;

public class GetAttackModifiers implements IEvent {
    private List<AttackModifier> modifiers;

    public GetAttackModifiers() {
        this.modifiers = new ArrayList<>();
    }

    @Override
    public void visit(AttackModifier attackModifier) {
        modifiers.add(attackModifier);
    }

    public List<AttackModifier> getModifiers() {
        return modifiers;
    }
}
