package 单子69重写;


import java.util.Random;

public abstract class Person {
    public static Random random = new Random();
    // 名字
    public String name;

    // 一次走几步
    public int step;

    // 血量
    public int hp;

    // 攻击力
    public int atk;

    // 当前的位置
    public int x;

    public boolean isDead = false;

    public Person(String name, int step, int hp, int atk, int x) {
        this.name = name;
        this.step = step;
        this.hp = hp;
        this.atk = atk;
        this.x = x;
    }

    public abstract void run();

    public abstract void jineng(Person person);

    public  void kill(Person person) {
        if(!person.isDead) {
            if (person.name.equals("曹操")) {
                boolean b = random.nextBoolean();
                System.out.print("抓到曹操!");
                if (b) {
                    System.out.println("放生曹操，逃生成功");

                } else {
                    System.out.println("杀死曹操，逃生失败");

                }
            } else {
                person.isDead = true;
                person.hp = 0;
                System.out.println(name + "杀死了" + person.name);
            }
        }

    }
}
