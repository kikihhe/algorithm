package question;

import java.util.ArrayList;


public class Question10 {
    public static void main(String[] args) {
        PetStore petStore = new PetStore();

        PetStore.Pet pet1 = new PetStore.Pet("aaa", "aaaa1", 10);
        PetStore.Pet pet2 = new PetStore.Pet("bbb", "bbbb1", 10);
        PetStore.Pet pet3 = new PetStore.Pet("ccc", "cccc1", 10);

        petStore.pets.add(pet1);
        petStore.pets.add(pet2);
        petStore.pets.add(pet3);

        petStore.display();
    }
}

class PetStore {
    public ArrayList<Pet> pets = new ArrayList<>();
    public static class Pet {
        public String name;
        public String type;
        public int age;

        public Pet(String name, String type, int age) {
            this.name = name;
            this.type = type;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public void display() {
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
