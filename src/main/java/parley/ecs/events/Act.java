package parley.ecs.events;

import parley.ecs.core.Action;
import parley.ecs.core.Entity;
import parley.ecs.core.IEvent;

import java.util.List;

public class Act implements IEvent {
    private List<Action> choices;

    public Act(List<Action> choices) {
        this.choices = choices;
    }

    public List<Action> getChoices() {
        return choices;
    }
}
