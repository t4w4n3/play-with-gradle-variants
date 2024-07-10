package context2.ports.outbound;

import context2.entities.AggregateRoot2;

import java.util.Optional;
import java.util.UUID;

public interface AggregateRoot2Repository {
    void save(AggregateRoot2 aggregateRoot1);

    Optional<AggregateRoot2> get(UUID id);
}
