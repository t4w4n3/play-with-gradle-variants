package context1.ports.inbound;

import context1.entities.AggregateRoot1InSpecificState;
import context1.ports.outbound.AggregateRoot1Repository;

import java.util.UUID;

public class UseCase1 {

    private final AggregateRoot1Repository aggregateRoot1Repository;

    public UseCase1(AggregateRoot1Repository aggregateRoot1Repository) {
        this.aggregateRoot1Repository = aggregateRoot1Repository;
    }

    public UUID execute() {
        UUID id = UUID.randomUUID();
        aggregateRoot1Repository.save(new AggregateRoot1InSpecificState(id));
        System.out.println("UseCase1 executed");
        return id;
    }
}