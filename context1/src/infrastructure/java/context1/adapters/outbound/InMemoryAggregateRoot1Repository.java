package context1.adapters.outbound;


import context1.entities.AggregateRoot1;
import context1.ports.outbound.AggregateRoot1Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryAggregateRoot1Repository implements AggregateRoot1Repository {

    private final Map<UUID, AggregateRoot1> memory = new HashMap<>();

    @Override
    public void save(AggregateRoot1 aggregateRoot1) {
        memory.put(aggregateRoot1.id(), aggregateRoot1);
    }

    @Override
    public Optional<AggregateRoot1> get(UUID id) {
        return Optional.ofNullable(memory.get(id));
    }
}
