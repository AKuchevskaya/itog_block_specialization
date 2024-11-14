package Java;

import java.util.List;

public abstract class PackAnimal extends Animal {
    public PackAnimal(String name, String birthDate, List<String> commands) {
        super(name, birthDate);
        this.commands.addAll(commands);
    }

    @Override
    public List<String> commandsList() {
        return commands;
    }
}