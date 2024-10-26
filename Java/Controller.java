package Java;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private List<Animal> animals;

    public Controller() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addNewAnimal(int animalType, String name, String birthDate, List<String> commands) {
        Animal newAnimal = null;
        switch (animalType) {
            case 1:
                newAnimal = new Cat(name, birthDate, commands);
                break;
            default:
                System.out.println("Неверный тип животного.");
        }
        if (newAnimal != null) {
            animals.add(newAnimal);
            System.out.println("Животное добавлено.");
        }
    }

    public void AllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Животных нет.");
            return;
        }

        System.out.println("Список всех животных:");
        for (Animal animal : animals) {
            System.out.println("Имя: " + animal.getName() + ", Тип: " + animal.getType() + ", Дата рождения: " + animal.getBirthDate());
            listAnimalCommands(animal.getName());
            System.out.println();
        }
    }

    public void listAnimalCommands(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println(name + " знает команды: ");
            for (String command : animal.getCommands()) {
                System.out.println(command);
            }
        } else {
            System.out.println(name + " не найдено. Попробуйте другое имя.");
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public int getTotalAnimalsCount() {
        return animals.size();
    }

}