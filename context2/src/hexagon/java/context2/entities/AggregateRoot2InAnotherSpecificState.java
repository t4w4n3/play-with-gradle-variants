package context2.entities;

import java.util.UUID;

public record AggregateRoot2InAnotherSpecificState(UUID id) implements AggregateRoot2 {
}
