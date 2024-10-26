package Java;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller registry = new Controller();
        Cat wiskes = new Cat("Wiskes", "2019-04-15", List.of("Sit", "Pounce"));
        Cat smude = new Cat("Smude", "2021-06-20", List.of("Sit", "Pounce", "Scratch"));
        Cat opra = new Cat("Opra", "2022-11-28", List.of("Meow", "Scratch", "Jump"));

        registry.addAnimal(wiskes);
        registry.addAnimal(smude);
        registry.addAnimal(opra);


        Navigation navigation = new Navigation(registry);
        navigation.start();
    }
}