package context2.ports.inbound;

import context1.ports.inbound.UseCase1;

public class UseCase3 {

    private final UseCase1 useCase1;

    public UseCase3(UseCase1 useCase1) {
        this.useCase1 = useCase1;
    }

    public void execute() {
        var id = useCase1.execute();
        System.out.println("UseCase3 executed. Id is : " + id);
    }
}