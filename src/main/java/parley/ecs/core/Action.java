package parley.ecs.core;

public class Action {
    private Entity target;
    private IEvent event;

    public Action(Entity target, IEvent event) {
        this.target = target;
        this.event = event;
    }

    public Entity getTarget() {
        return target;
    }

    public IEvent getEvent() {
        return event;
    }

    public void execute() {
        target.runEvent(event);
    }
}
