package 单子69;

import java.util.Random;

public class Person {
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
                person.hp = 0;
                System.out.println(name + "杀死了" + person.name);
            }
        }


    }

    public Person(String name, int step,  int x,  int bloodVolume, int aggressivity)
    {
        this.name = name;
        this.step = step;
        this.hp = bloodVolume;
        this.atk = aggressivity;
        this.x = x;

    }

    public static void main(String[] args)
    {


                int i = 0;
                Person caocao = new Person("曹操", 1, 10, 100, 0);
                Person xuhuang = new Person("徐晃", 1, 10, 70, 0);
                Person zhangliao = new Person("张辽", 1, 10, 50, 0);
                Person guanyu = new Person("关羽", 2, 0, 100, 100);

                boolean isKill = false;
                while (caocao.x > guanyu.x) {
                    // 先跑
                    guanyu.run();
                    caocao.run();
                    xuhuang.run();
                    zhangliao.run();
                    System.out.println("------------------------------");
                    System.out.println("此时已经跑了" + (++i) +"轮，每个人的位置为: \n" +
                            "曹操: " + caocao.x + "米, 血量: " + caocao.hp+ "\n" +
                            "徐晃: " + xuhuang.x + "米, 血量: " + xuhuang.hp +"\n" +
                            "张辽: " + zhangliao.x + "米, 血量: " + zhangliao.hp +"\n" +
                            "关羽: " + guanyu.x + "米, 攻击力: " + guanyu.atk
                    );

                    // 执行技能

                    caocao.jineng(null, 2);
                    xuhuang.jineng(caocao, 1);
                    zhangliao.jineng(guanyu, 1);
                    if (guanyu.x >= xuhuang.x) {
                        guanyu.kill(xuhuang);
                    }
                    if (guanyu.x >= zhangliao.x) {
                        guanyu.kill(zhangliao);
                    }
                    if (guanyu.x >= caocao.x) {
                        guanyu.kill(caocao);
                        break;
                    }
                    if (caocao.x - guanyu.x >= 20) {
                        System.out.println("曹操甩了关羽20米，逃跑成功!");
                        break;
                    }
                    System.out.println("触发技能后的位置为: \n" +
                            "曹操: " + caocao.x + "米\n" +
                            "徐晃: " + xuhuang.x + "米\n" +
                            "张辽: " + zhangliao.x + "米\n" +
                            "关羽: " + guanyu.x + "米"
                    );

                    System.out.println("------------------------------");
                }

        }



}
