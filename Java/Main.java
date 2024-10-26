package Java;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller registry = new Controller();
        Cat wiskes = new Cat("Wiskes", "2019-04-15", List.of("Sit", "Pounce"));
        Cat smude = new Cat("Smude", "2021-06-20", List.of("Sit", "Pounce", "Scratch"));
        Cat opra = new Cat("Opra", "2022-11-28", List.of("Meow", "Scratch", "Jump"));
        Dog difo = new Dog("Difo", "2021-01-04", List.of("Sit", "Stay", "Fetch"));
        Dog wuddy = new Dog("Wuddy", "2019-11-18", List.of("Sit", "Paw", "Bark"));
        Dog belka = new Dog("Belka", "2024-09-16", List.of("Sit", "Stay", "Roll"));

        registry.addAnimal(wiskes);
        registry.addAnimal(smude);
        registry.addAnimal(opra);
        registry.addAnimal(difo);
        registry.addAnimal(wuddy);
        registry.addAnimal(belka);


        Navigation navigation = new Navigation(registry);
        navigation.start();
    }
}