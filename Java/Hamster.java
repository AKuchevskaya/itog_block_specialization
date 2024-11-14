package Java;

import java.util.List;

public class Hamster extends DomesticAnimal{
    public Hamster(String name, String birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public List<String> commandsList() {
        return getCommands();
    }

    @Override
    public String getType() {
        return "Hamster";
    }
}
