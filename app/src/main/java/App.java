import context1.ports.inbound.UseCase1;
import context1.adapters.outbound.InMemoryAggregateRoot1Repository;
import context1.ports.inbound.UseCase2;
import context2.ports.inbound.UseCase3;

public class App {

    public static void main(String[] args) {
        var aggregateRoot1Repository = new InMemoryAggregateRoot1Repository();
        var usecase1 = new UseCase1(aggregateRoot1Repository);
        var id = usecase1.execute();
        var usecase2 = new UseCase2(aggregateRoot1Repository);
        usecase2.execute(id);
        var usecase3 = new UseCase3(usecase1);
        usecase3.execute();
    }
}
