package 演示;

import java.util.Random;

public class Person {
    // 名字
    public String name;

    // 一次走几步
    public int step;

    // 当前的位置
    public int x;

    public boolean isDead = false;

    // 移动
    public void run() {
        if (!isDead) {
            x += step;

        }
    }
    public static Random random = new Random();
    // 技能
    public void jineng(Person person, int step) {
        if (!name.equals("关羽") && isDead) {
            return;
        }
        // 如果这个人是曹操，可能触发奸雄技能
        if (name.equals("曹操")) {
            boolean b = random.nextBoolean();
            if (b) {
                System.out.println("曹操触发奸雄技能，多跑两米");
                x += step;
            }
            return;
        }
        // 如果被执行人为曹操，说明发动技能的人是 徐晃
        if (person.name.equals("曹操") && name.equals("徐晃")) {
                int i = random.nextInt(10);
                if (i < 3) {
                    System.out.println("徐晃触发护主技能，曹操多跑一米");
                    person.x++;
                }
                return;

        }
        // 如果被执行人为关羽，说明发动技能的人是张辽
        if (person.name.equals("关羽") && name.equals("张辽")) {
            int i = random.nextInt(10);
            if (i < 3) {
                person.x--;
                System.out.println("张辽触发忠臣技能，关羽被击退一米");
            }
            return;
        }
    }
    public  void kill(Person person) {
        if(!person.isDead) {
            if (person.name.equals("曹操")) {
                boolean b = random.nextBoolean();
                if (b) {
                    System.out.println("放生曹操，逃生成功");

                } else {
                    System.out.println("杀死曹操，逃生失败");

                }
            } else {
                person.isDead = true;
                System.out.println(name + "杀死了" + person.name);
            }
        }


    }

    public Person(String name, int step, int x) {
        this.name = name;
        this.step = step;
        this.x = x;
    }


}
