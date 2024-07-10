package context1.ports.outbound;

import context1.entities.AggregateRoot1;

import java.util.Optional;
import java.util.UUID;

public interface AggregateRoot1Repository {
    void save(AggregateRoot1 aggregateRoot1);

    Optional<AggregateRoot1> get(UUID id);
}
