package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navigation {
    private Controller registry;
    private Scanner scanner;

    public Navigation(Controller registry) {
        this.registry = registry;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AllAnimals();
                    break;
                case 2:
                    addAnimal();
                    break;
                case 3:
                    listAnimalCommands();
                    break;
                case 4:
                    trainCommand();
                    break;
                case 5:
                    listTotalAnimalsCount();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Что-то пошло не так... Попробуйте еще раз.");
            }
        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1 - Список всех животных");
        System.out.println("2 - Завести новое животное");
        System.out.println("3 - Список команд животного");
        System.out.println("4 - Добавить новую команду");
        System.out.println("5 - Сколько всего животных в списке");
        System.out.println("0 - Выход");
        System.out.print("Выберите действие: ");
    }

    private void AllAnimals() {
        registry.AllAnimals();
    }

    private void addAnimal() {
        System.out.println("Выберите тип животного:");
        System.out.println("1 - Кошка");
        System.out.println("2 - Собака");
        System.out.println("3 - Хомяк");
        System.out.println("4 - Лошадь");
        System.out.println("5 - Верблюд");
        System.out.println("6 - Осел");
        System.out.print("Введите номер типа животного: ");
        int animalType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения животного (гггг-мм-дд): ");
        String birthDate = scanner.nextLine();

        List<String> commands = new ArrayList<>();
        boolean addCommand;
        do {
            System.out.print("Введите команду (или 'q' для выхода): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                addCommand = false;
            } else {
                commands.add(command);
                System.out.println("Команда \"" + command + "\" добавлена.");
                System.out.print("Добавить еще команду? (yes/no): ");
                String addMore = scanner.nextLine();
                addCommand = addMore.equalsIgnoreCase("yes");
            }
        } while (addCommand);

        switch (animalType) {
            case 1:
                Cat cat = new Cat(name, birthDate, commands);
                registry.addAnimal(cat);
                break;
            case 2:
                Dog dog = new Dog(name, birthDate, commands);
                registry.addAnimal(dog);
                break;
            case 3:
                Hamster hamster = new Hamster(name, birthDate, commands);
                registry.addAnimal(hamster);
                break;
            case 4:
                Horse horse = new Horse(name, birthDate, commands);
                registry.addAnimal(horse);
                break;
            case 5:
                Camel camel = new Camel(name, birthDate, commands);
                registry.addAnimal(camel);
                break;
            case 6:
                Donkey donkey = new Donkey(name, birthDate, commands);
                registry.addAnimal(donkey);
                break;
            default:
                System.out.println("Неверный выбор типа животного.");
                break;
        }

        System.out.println("Новое животное успешно добавлено в реестр.");
    }

    private void listAnimalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = registry.findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды для " + name + ":");
            List<String> commands = animal.commandsList();
            for (String command : commands) {
                System.out.println(command);
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void trainCommand() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = registry.findAnimalByName(name);
        if (animal != null) {
            System.out.print("Введите новую команду для животного: ");
            String newCommand = scanner.nextLine();
            animal.addCommand(newCommand);
            System.out.println("Новая команда \"" + newCommand + "\" успешно добавлена для " + name);
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void listTotalAnimalsCount() {
        int totalAnimalsCount = registry.getTotalAnimalsCount();
        System.out.println("Общее количество животных в реестре: " + totalAnimalsCount);
    }
}