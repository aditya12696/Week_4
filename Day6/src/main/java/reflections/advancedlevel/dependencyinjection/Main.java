package reflections.advancedlevel.dependencyinjection;

public class Main {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();


        container.register(Service.class);


        Client client = new Client();


        container.injectDependencies(client);


        client.run();
    }
}
