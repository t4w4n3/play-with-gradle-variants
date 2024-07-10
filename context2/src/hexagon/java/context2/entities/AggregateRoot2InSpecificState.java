package context2.entities;

import java.util.UUID;

public record AggregateRoot2InSpecificState(UUID id) implements AggregateRoot2 {

    public AggregateRoot2InAnotherSpecificState someBehavior() {
        return new AggregateRoot2InAnotherSpecificState(id);
    }
}
