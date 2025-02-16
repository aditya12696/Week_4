package reflections.advancedlevel.dependencyinjection;

public class Client {
    @Inject
    public ServiceImpl service;

    public void run() {
        service.execute();
    }
}
