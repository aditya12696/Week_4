package reflections.advancedlevel.jsonrepresentation;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Johan", 30, true);


        String json = JsonSerializer.toJson(person);


        System.out.println(json);
    }
}
