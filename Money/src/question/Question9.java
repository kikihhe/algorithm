package question;

import java.util.ArrayList;

public class Question9 {

    public static void main(String[] args) {
        Farm farm = new Farm();
        Farm.Animal animal1 = new Farm.Animal("tom", "cat", 2);
        Farm.Animal animal2 = new Farm.Animal("jack", "dog", 5);
        Farm.Animal animal3 = new Farm.Animal("david", "lion", 1);
        Farm.Animal animal4 = new Farm.Animal("dff", "tiger", 7);

        farm.animals.add(animal1);
        farm.animals.add(animal2);
        farm.animals.add(animal3);
        farm.animals.add(animal4);

        farm.display();
    }
}

class Farm {
    public static class Animal {
        public String name;
        public String species;
        public int age;

        public Animal(String name, String species, int age) {
            this.name = name;
            this.species = species;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", species='" + species + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public ArrayList<Animal> animals = new ArrayList<>();
    public void display() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
