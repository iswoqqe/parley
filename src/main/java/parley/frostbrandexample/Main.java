package parley.frostbrandexample;

import parley.ecs.components.Tag;
import parley.ecs.core.Engine;
import parley.ecs.core.IEntity;
import parley.ecs.core.IGameState;
import parley.ecs.core.ISystem;
import parley.frostbrandexample.components.AttackModifier;
import parley.frostbrandexample.components.Health;
import parley.frostbrandexample.events.PerformAttack;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();

        // target
        engine.newEntity()
                .withComponent(new Health(100))
                .withTag(Tag.Target)
                .build();

        // normal weapon
        engine.newEntity()
                .withComponent(new AttackModifier(10, AttackModifier.Type.Slashing))
                .withTag(Tag.Weapon)
                .build();

        // fire weapon
        engine.newEntity()
                .withComponent(new AttackModifier(10, AttackModifier.Type.Slashing))
                .withComponent(new AttackModifier(10, AttackModifier.Type.Fire))
                .withTag(Tag.Weapon)
                .build();

        // ice weapon
        engine.newEntity()
                .withComponent(new AttackModifier(10, AttackModifier.Type.Slashing))
                .withComponent(new AttackModifier(10, AttackModifier.Type.Ice))
                .withTag(Tag.Weapon)
                .build();

        // frostbrandweapon weapon
        engine.newEntity()
                .withComponent(new AttackModifier(10, AttackModifier.Type.Slashing))
                .withComponent(new AttackModifier(10, AttackModifier.Type.Fire))
                .withComponent(new AttackModifier(10, AttackModifier.Type.Ice))
                .withTag(Tag.Weapon)
                .build();


        engine.runSystem(new ISystem() {
            @Override
            public void run(IGameState entities) {
                // let each weapon attack each target
                for (IEntity target : entities.allWithTags(Tag.Target)) {
                    for (IEntity weapon : entities.allWithTags(Tag.Weapon)) {
                        weapon.fireEvent(new PerformAttack(target));
                    }
                }
            }
        });
    }
}
