package context1.ports.inbound;

import context1.ports.outbound.AggregateRoot1Repository;

import java.util.UUID;

public class UseCase2 {

    private final AggregateRoot1Repository aggregateRoot1Repository;

    public UseCase2(AggregateRoot1Repository aggregateRoot1Repository) {
        this.aggregateRoot1Repository = aggregateRoot1Repository;
    }

    public void execute(UUID id) {
        aggregateRoot1Repository.get(id).ifPresentOrElse(
                aggregateRoot1 -> System.out.println("AggregateRoot1 found: " + aggregateRoot1),
                () -> System.out.println("AggregateRoot1 not found"));
        System.out.println("UseCase2 executed");
    }
}