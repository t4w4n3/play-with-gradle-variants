package context2.adapters.outbound;

import context2.entities.AggregateRoot2;
import context2.ports.outbound.AggregateRoot2Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryAggregateRoot2Repository implements AggregateRoot2Repository {

    private final Map<UUID, AggregateRoot2> memory = new HashMap<>();

    @Override
    public void save(AggregateRoot2 aggregateRoot1) {
        memory.put(aggregateRoot1.id(), aggregateRoot1);
    }

    @Override
    public Optional<AggregateRoot2> get(UUID id) {
        return Optional.ofNullable(memory.get(id));
    }
}
