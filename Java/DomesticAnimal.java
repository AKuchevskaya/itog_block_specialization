package Java;

import java.util.List;

public abstract class DomesticAnimal extends Animal {
    public DomesticAnimal(String name, String birthDate, List<String> commands) {
        super(name, birthDate);
        this.commands.addAll(commands);
    }

    @Override
    public List<String> commandsList() {
        return commands;
    }
}