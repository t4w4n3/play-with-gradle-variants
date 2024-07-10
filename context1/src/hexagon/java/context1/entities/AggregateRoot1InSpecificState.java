package context1.entities;

import java.util.UUID;

public record AggregateRoot1InSpecificState(UUID id) implements AggregateRoot1 {

    public AggregateRoot1InAnotherSpecificState someBehavior() {
        return new AggregateRoot1InAnotherSpecificState(id);
    }
}
