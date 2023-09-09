package 单子99;

public class Animal {
    public void speak() {
        System.out.println("动物说话了");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("猫说话了");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("狗说话了");
    }
}