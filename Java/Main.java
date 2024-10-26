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
        Hamster bammy = new Hamster("Bammy", "2022-03-20", List.of("Roll", "Hide"));
        Hamster peanut = new Hamster("Peanut", "2023-10-06", List.of("Roll", "Spin"));
        Hamster liver = new Hamster("Liver", "2023-06-30", List.of("Roll", "Jump"));
        Horse sahara = new Horse("Sahara", "2016-02-29", List.of("Walk", "Run", "Gallop"));
        Horse sandy = new Horse("Sandy", "2015-08-14", List.of("Trot", "Canter"));

        registry.addAnimal(wiskes);
        registry.addAnimal(smude);
        registry.addAnimal(opra);
        registry.addAnimal(difo);
        registry.addAnimal(wuddy);
        registry.addAnimal(belka);
        registry.addAnimal(bammy);
        registry.addAnimal(peanut);
        registry.addAnimal(liver);
        registry.addAnimal(sahara);
        registry.addAnimal(sandy);


        Navigation navigation = new Navigation(registry);
        navigation.start();
    }
}