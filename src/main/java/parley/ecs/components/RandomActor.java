package parley.ecs.components;

import parley.ecs.core.Action;
import parley.ecs.core.Entity;
import parley.ecs.core.IEvent;
import parley.ecs.core.IComponent;
import parley.ecs.events.Act;

import java.util.List;
import java.util.Random;

public class RandomActor implements IComponent {
    private Random rng;

    public RandomActor() {
        this.rng = new Random();
    }

    @Override
    public void runEvent(IEvent event, Entity self) {
        if (event instanceof Act) {
            List<Action> choices = ((Act) event).getChoices();
            Action choice = choices.get(rng.nextInt(choices.size()));
            choice.execute();
        }
    }
}
